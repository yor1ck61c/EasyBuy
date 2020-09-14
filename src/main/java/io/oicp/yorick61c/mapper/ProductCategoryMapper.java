package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbProductCategory;

import java.util.List;

public interface ProductCategoryMapper {

    List<EbProductCategory> findProductCategoryByPage();

}
