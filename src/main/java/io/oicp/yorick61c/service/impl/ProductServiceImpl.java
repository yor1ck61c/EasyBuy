package io.oicp.yorick61c.service.impl;

import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.mapper.ProductMapper;
import io.oicp.yorick61c.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Resource(name = "productMapper")
    ProductMapper productMapper;

    @Override
    public void saveProduct(EbProduct product) {
        productMapper.insert(product);
    }

    @Override
    public PageBean<EbProduct> findProductByPage(Integer currentPage, Integer row) {
        PageBean<EbProduct> ebProductPageBean = new PageBean<>();
        ebProductPageBean.setCurrentPage(currentPage);
        ebProductPageBean.setRows(row);
        PageHelper.startPage(currentPage,row);
        ebProductPageBean.setItems(productMapper.findAll());
        int totalProduct = productMapper.countProduct();
        ebProductPageBean.setTotalItems(totalProduct);
        ebProductPageBean.setTotalPages(
                totalProduct % row == 0 ? totalProduct / row : (totalProduct / row) + 1
        );
        return ebProductPageBean;
    }

    @Override
    public void deleteProduct(Integer epId) {
        EbProduct product = new EbProduct();
        product.setEpId(epId);//根据id删除指定商品
        productMapper.delete(product);
    }

    @Override
    public EbProduct findProduct(Integer epId) {
        EbProduct product = new EbProduct();
        product.setEpId(epId);
        return productMapper.findProduct(product);
    }

    @Override
    public void updateProduct(EbProduct product) {
        productMapper.update(product);
    }

    @Override
    public List<EbProduct> findCPLById(Integer epcId) {
        return productMapper.findCPLById(epcId);
    }
}
