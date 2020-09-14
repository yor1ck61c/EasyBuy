package io.oicp.yorick61c.test;

import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//导入spring的配置文件
@ContextConfiguration("classpath:spring-mvc.xml")
public class TestProduct {

    @Resource(name = "productMapper")
    ProductMapper productMapper;

    @Test
    public void testSelect(){
        List<EbProduct> all = productMapper.findAll();
        for (EbProduct p: all
             ) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testSelectByCondition(){
        EbProduct product = new EbProduct();
        product.setEpId(591);

        EbProduct product1 = productMapper.findProduct(product);
        System.out.println(product1);
    }

    @Test
    public void testUpdate(){
        PageHelper.startPage(1,1);
        List<EbProduct> all = productMapper.findAll();
        EbProduct product = all.get(0);

        product.setEpPrice(new BigDecimal(150));
        productMapper.update(product);
    }

    @Test
    public void testInsert(){
        PageHelper.startPage(1,1);
        List<EbProduct> all = productMapper.findAll();
        EbProduct product = all.get(0);
        productMapper.insert(product);
    }

    @Test
    public void testDelete(){
        EbProduct product = new EbProduct();
        product.setEpId(664);
        productMapper.delete(product);
    }




}
