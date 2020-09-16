package io.oicp.yorick61c.service.impl;

import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.mapper.ProductMapper;
import io.oicp.yorick61c.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Resource(name = "productMapper")
    ProductMapper productMapper;

    @Override
    public void saveProduct(EbProduct product) {
        productMapper.insert(product);
    }
}
