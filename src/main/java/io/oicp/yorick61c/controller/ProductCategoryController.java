package io.oicp.yorick61c.controller;

import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.domain.EbProductCategory;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.ProductCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Resource(name = "productCategoryService")
    private ProductCategoryService productCategoryService;

    @RequestMapping(name = "/beforeInsert")
    public ModelAndView beforeInsert(ModelAndView modelAndView){
        modelAndView.addObject("list",productCategoryService.findAll());
        modelAndView.setViewName("manage/productClass-add");
        return modelAndView;
    }

    @RequestMapping("/insert")
    public String insert(EbProductCategory ebProductCategory){
        productCategoryService.insert(ebProductCategory);
        return "redirect:/productCategory/list/1/5";
    }

    @RequestMapping("/update/{epcId}")
    public String update(EbProductCategory pc,@PathVariable Integer epcId){
        pc.setEpcId(epcId);
        productCategoryService.update(pc);
        return "redirect:/productCategory/list/1/5";
    }

    @RequestMapping("/beforeUpdate/{epcId}")
    public ModelAndView beforeUpdate(@PathVariable Integer epcId){
        EbProductCategory pcById = productCategoryService.findPCById(epcId);
        List<EbProductCategory> list = productCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manage/productClass-modify");
        modelAndView.addObject("pc",pcById);
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @RequestMapping("/delete/{epcId}")
    public String delete(@PathVariable Integer epcId){
        productCategoryService.delete(epcId);
        return "redirect:/productCategory/list/1/5";
    }

    @RequestMapping("/list/{currentPage}/{row}")
    public ModelAndView productList(@PathVariable Integer currentPage, @PathVariable Integer row){
        if (currentPage == null)
            currentPage = 1;
        if (row == null)
            row = 3;

        PageBean<EbProductCategory> pageBean = productCategoryService.findProductByPage(currentPage, row);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productCategoryList",pageBean);
        modelAndView.setViewName("manage/productClass");
        return modelAndView;
    }
}
