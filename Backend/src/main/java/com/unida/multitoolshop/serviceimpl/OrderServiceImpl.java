package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.OrderData;
import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.model.Order;
import com.unida.multitoolshop.model.SetOption;
import com.unida.multitoolshop.repository.OrderDataRepository;
import com.unida.multitoolshop.service.CustomerService;
import com.unida.multitoolshop.service.MultiToolSetService;
import com.unida.multitoolshop.service.OrderService;
import com.unida.multitoolshop.service.SetOptionService;
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

    @Autowired
    CustomerService customerService;

    @Autowired
    SetOptionService setOptionService;

    @Autowired
    MultiToolSetService multiToolSetService;

    private Order convert(OrderData orderData) {
        Order order = new Order();
        order.setId(orderData.getId());
        List<SetOption> setOptions = new ArrayList<>();
        for (String setOptionId : orderData.getOptionIds().split(","))
            try {
                setOptions.add(setOptionService.getById(Integer.parseInt(setOptionId)));
            }catch (Exception e) {
                continue;
            }
        order.setOptions(setOptions);
        order.setTotalPrice(orderData.getTotalPrice());
        order.setCreated(orderData.getCreated());
        order.setStatus(orderData.getStatus());
        Customer customer = customerService.getById(orderData.getCustomerId());
        if (customer != null) {
            order.setCustomer(customer);
        }
        return order;
    }

    private OrderData convert(Order order) {
        OrderData orderData = new OrderData();
        orderData.setId(order.getId());
        orderData.setCustomerId(order.getCustomer().getId());
        StringBuilder options = new StringBuilder();
        for (SetOption setOption : order.getOptions()) {
            options.append(setOption.getId()).append(",");
        }
        orderData.setOptionIds(options.toString());
        orderData.setTotalPrice(order.getTotalPrice());
        orderData.setCreated(order.getCreated());
        orderData.setStatus(order.getStatus());
        return orderData;
    }

    @Override
    public List<Order> getAllByCustomerId(int customerId) {
        List<Order> orderList = new ArrayList<>();
        for (OrderData orderData : orderDataRepository.findAll()) {
            if (orderData.getCustomerId() == customerId) {
                orderList.add(this.convert(orderData));
            }
        }
        logger.info("Returned list with length of " + orderList.size());
        return orderList;
    }

    @Override
    public Order getById(int id) {
        Optional<OrderData> orderData = orderDataRepository.findById(id);
        if (orderData.isPresent()) {
            logger.info("Returned Order with id of " + orderData.get().getId());
            return this.convert(orderData.get());
        }
        return null;
    }

    @Override
    public Order create(Order order) {
        OrderData orderData = this.convert(order);
        Order newOrder = this.convert(orderDataRepository.save(orderData));
        logger.info("Created Order with id " + newOrder.getId());
        return newOrder;
    }
}
