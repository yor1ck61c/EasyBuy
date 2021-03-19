package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbNews;
import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.domain.EbProductCategory;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.NewsService;
import io.oicp.yorick61c.service.ProductCategoryService;
import io.oicp.yorick61c.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Resource(name = "ProductService")
    private ProductService productService;

    @Resource(name = "NewsService")
    private NewsService newsService;

    @Resource(name = "productCategoryService")
    private ProductCategoryService productCategoryService;

    @RequestMapping("/welcome/{currentPage}/{row}")
    public ModelAndView beforeIndex(HttpSession session,ModelAndView modelAndView, @PathVariable Integer currentPage, @PathVariable Integer row){
        List<EbProductCategory> parent = productCategoryService.findParent();//获取父分类
        List<EbProductCategory> child = productCategoryService.findChild();//获取子分类
        session.setAttribute("parent",parent);//将父分类和子分类存入Session域
        session.setAttribute("child",child);
        /*
        * 获取对应产品信息
        * 每页显示8个
        * 默认获取数据库中前八个产品，并展示在第一页
        * */
        PageBean<EbProduct> products = productService.findProductByPage(currentPage, row);
        List<EbNews> news = newsService.findAll();//获取新闻
        modelAndView.addObject("products",products);//将产品信息装入model域
        modelAndView.addObject("news",news);//将新闻信息装入model域
        modelAndView.setViewName("index");//跳转至首页
        return modelAndView;
    }

    @RequestMapping("/addUser")
    public String addUser(){
        return "manage/user-add";
    }


}
