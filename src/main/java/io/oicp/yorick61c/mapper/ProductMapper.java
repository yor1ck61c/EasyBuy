package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbProduct;

import java.util.List;

public interface ProductMapper {

    List<EbProduct> findAll();

    EbProduct findProduct(EbProduct product);

    void update(EbProduct product);

    void delete(EbProduct product);

    void insert(EbProduct product);

}
