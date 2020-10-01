package io.oicp.yorick61c.service.impl;

import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.domain.EbProductCategory;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.mapper.ProductCategoryMapper;
import io.oicp.yorick61c.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource(name = "productCategoryMapper")
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public PageBean<EbProductCategory> findProductByPage(Integer currentPage, Integer row) {

        PageBean<EbProductCategory> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(row);
        PageHelper.startPage(currentPage,row);
        pageBean.setItems(productCategoryMapper.findAll());
        int totalProduct = productCategoryMapper.countPC();
        pageBean.setTotalItems(totalProduct);
        pageBean.setTotalPages(
                totalProduct % row == 0 ? totalProduct / row : (totalProduct / row) + 1
        );
        return pageBean;
    }

    @Override
    public void delete(Integer epcId) {
        EbProductCategory ebProductCategory = new EbProductCategory();
        ebProductCategory.setEpcId(epcId);
        productCategoryMapper.delete(ebProductCategory);
    }

    @Override
    public EbProductCategory findPCById(Integer epcId) {
        EbProductCategory ebProductCategory = new EbProductCategory();
        ebProductCategory.setEpcId(epcId);
        return productCategoryMapper.findProductCategory(ebProductCategory);
    }

    @Override
    public void update(EbProductCategory pc) {
        productCategoryMapper.update(pc);
    }

    @Override
    public void insert(EbProductCategory ebProductCategory) {
        productCategoryMapper.insert(ebProductCategory);
    }

    @Override
    public List<EbProductCategory> findAll() {
        return productCategoryMapper.findAll();
    }

    @Override
    public List<EbProductCategory> findParent() {
        return productCategoryMapper.findParent();
    }

    @Override
    public List<EbProductCategory> findChild() {
        return productCategoryMapper.findChild();
    }
}
