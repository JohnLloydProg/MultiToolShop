package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.CustomerData;
import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.repository.CustomerDataRepository;
import com.unida.multitoolshop.service.CustomerService;
import com.unida.multitoolshop.util.Transformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    CustomerDataRepository customerDataRepository;


    @Override
    public Customer getById(int id) {
        Optional<CustomerData> customerData = customerDataRepository.findById(id);
        if (customerData.isPresent()) {
            logger.info("Returned Customer with id " + customerData.get().getId());
            return Transformer.convert(customerData.get());
        }else {
            logger.info("Couldn't find Customer with id " + id);
        }
        return null;
    }

    @Override
    public Customer create(Customer customer) {
        CustomerData customerData = Transformer.convert(customer);
        Customer newCustomer = Transformer.convert(customerDataRepository.save(customerData));
        logger.info("Created Customer with id " + newCustomer.getId());
        return newCustomer;
    }

    @Override
    public Customer update(Customer customer) {
        CustomerData customerData = Transformer.convert(customer);
        Customer newCustomer = Transformer.convert(customerDataRepository.save(customerData));
        logger.info("Updated Customer with id " + newCustomer.getId());
        return newCustomer;
    }

    @Override
    public void delete(int id) {
        Optional<CustomerData> customerData = customerDataRepository.findById(id);
        if (customerData.isPresent()) {
            logger.info("Deleted Customer with id " + customerData.get().getId());
            customerDataRepository.delete(customerData.get());
        }else {
            logger.info("Couldn't find Customer with id " + id);
        }
    }
}
