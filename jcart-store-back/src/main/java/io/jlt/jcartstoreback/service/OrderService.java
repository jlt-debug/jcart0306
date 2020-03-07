package io.jlt.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.jlt.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.jlt.jcartstoreback.dto.out.OrderShowOutDTO;
import io.jlt.jcartstoreback.po.Order;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,Integer customerId);


    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

    OrderShowOutDTO getById(Long orderId);
}
