package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.OrderData;
import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.model.Order;
import com.unida.multitoolshop.repository.OrderDataRepository;
import com.unida.multitoolshop.service.OrderService;
import com.unida.multitoolshop.util.Transformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    OrderDataRepository orderDataRepository;

    @Override
    public List<Order> getAllByCustomer(Customer customer) {
        List<Order> orderList = new ArrayList<>();
        for (OrderData orderData : orderDataRepository.findAll()) {
            if (orderData.getCustomerData().equals(customer)) {
                orderList.add(Transformer.convert(orderData));
            }
        }
        logger.info("Returned list with length of " + orderList.size());
        return orderList;
    }

    @Override
    public Order getById(Integer id) {
        Optional<OrderData> orderData = orderDataRepository.findById(id);
        if (orderData.isPresent()) {
            logger.info("Returned Order with id of " + orderData.get().getId());
            return Transformer.convert(orderData.get());
        }
        return null;
    }

    @Override
    public Order create(Order order) {
        OrderData orderData = Transformer.convert(order);
        Order newOrder = Transformer.convert(orderDataRepository.save(orderData));
        logger.info("Created Order with id " + newOrder.getId());
        return newOrder;
    }
}
