package io.oicp.yorick61c.exception;

import io.oicp.yorick61c.domain.PageBean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常
     *
     * @param request
     * @param response
     * @param handler
     * @param ex       抛出的异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取异常对象
        MyException myException = null;
        //如果是预期的异常，则获取异常信息
        if (ex instanceof MyException) {
            myException = (MyException) ex;
        } else if (ex instanceof DuplicateKeyException) {
            myException = new MyException("该用户名已被使用，换个名字试试");
        }
        else {
            //不是预测的异常，则统一为系统维护
            myException = new MyException("系统正在维护...");
        }
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", myException.getMessage());
        //返回错误提示页面
        modelAndView.setViewName("manage/error");
        return modelAndView;

    }

}
