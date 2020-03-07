package io.jlt.jcartstoreback.service;

import io.jlt.jcartstoreback.dto.in.CustomerRegisterInDTO;
import io.jlt.jcartstoreback.po.Customer;

public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    void update(Customer customer);

}
