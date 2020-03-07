package io.jlt.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.jlt.jcartadministrationback.po.Administrator;

import java.util.List;

public interface AdministratorService {

    Administrator getByUsername(String username);

    Administrator getById(Integer administratorId);

    void update(Administrator administrator);

    Integer create(Administrator administrator);

    void delete(Integer administratorId);

    void batchDelete(List<Integer> administratorIds);

    Page<Administrator> getList(Integer pageNum);
}
