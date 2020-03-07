package io.jlt.jcartadministrationback.service;

import io.jlt.jcartadministrationback.po.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressService {

    List<Address> getByCustomerId(Integer customerId);

    Address getById(Integer addressId);
}
