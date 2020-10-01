package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbOrder;
import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource(name = "ProductService")
    private ProductService productService;

    @RequestMapping("/clearSC")
    public String clearSC(HttpSession session){
        session.removeAttribute("shoppingCart");
        return "shopping-result";
    }

    @RequestMapping("/getChildProductList/{epcId}")
    public ModelAndView getCPL(@PathVariable Integer epcId, ModelAndView modelAndView){
        List<EbProduct> CPL = productService.findCPLById(epcId);

        modelAndView.addObject("cpl",CPL);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/deleteSC/{epId}")
    @SuppressWarnings("unchecked")
    public String deleteSC(@PathVariable Integer epId,HttpSession session){
        //删除商品功能
        List<EbProduct> shoppingCart = (List<EbProduct>) session.getAttribute("shoppingCart");
        //获取购物车中的商品列表
        shoppingCart.remove(productService.findProduct(epId));
        //根据id获取需要删除的商品信息，并移除该商品
        session.setAttribute("shoppingCart",shoppingCart);
        //更新购物车，返回购物车页面
        return "shopping";
    }

    @RequestMapping("/addToShoppingCart/{epId}")
    @SuppressWarnings("unchecked")
    public String addToShoppingCart(@PathVariable Integer epId, HttpSession session){
        if(session.getAttribute("shoppingCart") != null){
            /*
            * 购物车功能
            * 判断购物车是否为空，如果非空，获取购物车，并增加选中商品
            * 如果购物车为空，创建购物车，并将商品加入购物车，返回购物界面
            * */
            List<EbProduct> shoppingCart = (List<EbProduct>) session.getAttribute("shoppingCart");
            shoppingCart.add(productService.findProduct(epId));
            session.setAttribute("shoppingCart",shoppingCart);
        }else {
            List<EbProduct> shoppingCart = new ArrayList<>();
            shoppingCart.add(productService.findProduct(epId));
            session.setAttribute("shoppingCart",shoppingCart);
        }
        return "redirect:/index/welcome/1/8";
    }

    @RequestMapping("/view/{epId}")
    @SuppressWarnings("unchecked")
    public ModelAndView viewProduct(ModelAndView modelAndView, @PathVariable Integer epId, HttpSession session){
        EbProduct product = productService.findProduct(epId);
        //根据id获取对应商品信息
        if (session.getAttribute("recentView") != null){
            List<EbProduct> recentView = (List<EbProduct>) session.getAttribute("recentView");
            //若session域中有对应浏览记录，先取出
            if (recentView.indexOf(product) == -1){
                recentView.add(product);
                session.setAttribute("recentView",recentView);
                //若session域中不包含刚刚浏览过的商品信息，就存入，并更新session域。
            }
        }else{
            List<EbProduct> recentView = new ArrayList<>();
            recentView.add(product);
            session.setAttribute("recentView",recentView);
            //若session中没有浏览记录，就新建一个浏览记录，并将刚刚浏览过的商品信息存入
        }
        modelAndView.addObject("product",product);
        modelAndView.setViewName("manage/product-view");
        //用户点击某个商品后，产生对应浏览记录，并跳转至浏览商品详情界面
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(){
        return "/manage/product-add";
    }

    @RequestMapping("/save")
    public String saveProduct(@RequestParam("file") MultipartFile file,EbProduct product) throws IOException {
        String filename = file.getOriginalFilename();
        file.transferTo(new File("C:\\Users\\ASUS\\IdeaProjects\\EasyBuy\\src\\main\\webapp\\images\\product\\" + filename));
        product.setEpFileName(filename);
        productService.saveProduct(product);
        return "redirect:/product/list/1/3";
    }

    @RequestMapping("/list/{currentPage}/{row}")
    public ModelAndView productList(@PathVariable Integer currentPage, @PathVariable Integer row){
        if (currentPage == null)
            currentPage = 1;
        if (row == null)
            row = 3;

        PageBean<EbProduct> productByPage = productService.findProductByPage(currentPage, row);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productByPage);
        modelAndView.setViewName("manage/product");
        return modelAndView;
    }

    @RequestMapping("/delete/{epId}")
    public String delete(@PathVariable Integer epId){
        productService.deleteProduct(epId);
        return "redirect:/product/list/1/3";
    }

    @RequestMapping("/beforeUpdate/{epId}")
    public ModelAndView beforeUpdate(@PathVariable Integer epId){
        EbProduct product = productService.findProduct(epId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",product);
        modelAndView.setViewName("manage/product-modify");
        return modelAndView;
    }

    @RequestMapping("/update/{epId}")
    public String updateProduct(@RequestParam("file") MultipartFile file,EbProduct product,@PathVariable Integer epId) throws IOException {
        String filename = file.getOriginalFilename();
        file.transferTo(new File("C:\\Users\\ASUS\\IdeaProjects\\EasyBuy\\src\\main\\webapp\\images\\product\\" + filename));
        product.setEpFileName(filename);
        product.setEpId(epId);
        productService.updateProduct(product);
        return "redirect:/product/list/1/3";
    }

}
