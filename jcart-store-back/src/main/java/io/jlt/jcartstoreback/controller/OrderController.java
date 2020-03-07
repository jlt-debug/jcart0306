package io.jlt.jcartstoreback.controller;

import com.github.pagehelper.Page;
import io.jlt.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.jlt.jcartstoreback.dto.out.OrderListOutDTO;
import io.jlt.jcartstoreback.dto.out.OrderShowOutDTO;
import io.jlt.jcartstoreback.dto.out.PageOutDTO;
import io.jlt.jcartstoreback.po.Order;
import io.jlt.jcartstoreback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){

        Long checkout = orderService.checkout(orderCheckoutInDTO, customerId);


        return checkout;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestAttribute Integer customerId){


        Page<Order> page = orderService.getByCustomerId(pageNum, customerId);
        List<OrderListOutDTO> orderListOutDTOS = page.stream().map(order ->{

            OrderListOutDTO orderListOutDTO = new OrderListOutDTO();
            orderListOutDTO.setOrderId(order.getOrderId());
            orderListOutDTO.setStatus(order.getStatus());
            orderListOutDTO.setTotalPrice(order.getTotalPrice());
            orderListOutDTO.setCreateTimestamp(order.getCreateTime().getTime());

            return orderListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(orderListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){

        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);


        return orderShowOutDTO;
    }
}
