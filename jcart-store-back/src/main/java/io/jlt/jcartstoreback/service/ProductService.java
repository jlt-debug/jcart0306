package io.jlt.jcartstoreback.service;


import com.github.pagehelper.Page;
import io.jlt.jcartstoreback.dto.out.ProductListOutDTO;
import io.jlt.jcartstoreback.dto.out.ProductShowOutDTO;
import io.jlt.jcartstoreback.po.Product;

public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);

}
