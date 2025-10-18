package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.CustomerData;
import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.repository.CustomerDataRepository;
import com.unida.multitoolshop.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    CustomerDataRepository customerDataRepository;

    private Customer convert(CustomerData customerData) {
        Customer customer = new Customer();
        customer.setId(customerData.getId());
        customer.setFirstName(customerData.getFirstName());
        customer.setMiddleName(customerData.getMiddleName());
        customer.setLastName(customerData.getLastName());
        customer.setEmail(customerData.getEmail());
        customer.setPassword(customerData.getPassword());
        customer.setAddress(customerData.getAddress());
        customer.setContactNumber(customerData.getContactNumber());
        customer.setBirthdate(customerData.getBirthdate());
        customer.setCreated(customerData.getCreated());
        customer.setUpdated(customerData.getUpdated());
        return customer;
    }

    private CustomerData convert(Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setMiddleName(customer.getMiddleName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        customerData.setPassword(customer.getPassword());
        customerData.setAddress(customer.getAddress());
        customerData.setContactNumber(customer.getContactNumber());
        customerData.setBirthdate(customer.getBirthdate());
        customerData.setCreated(customer.getCreated());
        customerData.setUpdated(customer.getUpdated());
        return customerData;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerData customerData : customerDataRepository.findAll()) {
            customerList.add(this.convert(customerData));
        }
        return customerList;
    }

    @Override
    public Customer getById(int id) {
        Optional<CustomerData> customerData = customerDataRepository.findById(id);
        if (customerData.isPresent()) {
            logger.info("Returned Customer with id " + customerData.get().getId());
            return this.convert(customerData.get());
        }else {
            logger.info("Couldn't find Customer with id " + id);
        }
        return null;
    }

    @Override
    public Customer create(Customer customer) {
        CustomerData customerData = this.convert(customer);
        Customer newCustomer = this.convert(customerDataRepository.save(customerData));
        logger.info("Created Customer with id " + newCustomer.getId());
        return newCustomer;
    }

    @Override
    public Customer update(Customer customer) {
        CustomerData customerData = this.convert(customer);
        Customer newCustomer = this.convert(customerDataRepository.save(customerData));
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
