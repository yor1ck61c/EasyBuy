package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource(name = "ProductService")
    private ProductService productService;

    @RequestMapping("/add")
    public String add(){
        return "/manage/product-add";
    }

    @RequestMapping("/save")
    public String saveProduct(@RequestParam("file") MultipartFile file,EbProduct product) throws IOException {
        System.out.println(product.toString());
        String filename = file.getOriginalFilename();
        file.transferTo(new File("C:\\Users\\ASUS\\IdeaProjects\\EasyBuy\\src\\main\\webapp\\upload\\temp" + filename));
        product.setEpFileName(filename);
        productService.saveProduct(product);
        return null;
    }
}
