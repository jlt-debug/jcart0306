package io.jlt.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.jlt.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import io.jlt.jcartadministrationback.po.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerService {
    Page<Customer> search(Integer pageNum);

    Customer getById(Integer customerId);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);
}
