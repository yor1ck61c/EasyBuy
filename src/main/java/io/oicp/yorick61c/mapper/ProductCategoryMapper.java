package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbProductCategory;

import java.util.List;

public interface ProductCategoryMapper {

    Integer countPC();

    EbProductCategory findProductCategory(EbProductCategory ebProductCategory);

    List<EbProductCategory> findAll();

    void insert(EbProductCategory ebProductCategory);

    void delete(EbProductCategory ebProductCategory);

    void update(EbProductCategory ebProductCategory);

    List<EbProductCategory> findParent();

    List<EbProductCategory> findChild();
}
