package io.jlt.jcartadministrationback.service.impl;

import io.jlt.jcartadministrationback.dao.OrderHistoryMapper;
import io.jlt.jcartadministrationback.po.OrderHistory;
import io.jlt.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderHistory> getByOrderId(Long orderId) {

        List<OrderHistory> orderHistories = orderHistoryMapper.selectByOrderId(orderId);


        return orderHistories;
    }

    @Override
    public Long create(OrderHistory orderHistory) {

        orderHistoryMapper.insertSelective(orderHistory);
        Long orderHistoryId = orderHistory.getOrderHistoryId();

        return orderHistoryId;
    }
}
