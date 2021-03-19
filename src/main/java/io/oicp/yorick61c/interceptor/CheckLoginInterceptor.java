package io.oicp.yorick61c.interceptor;

import io.oicp.yorick61c.domain.EbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    //拦截到请求后，在Controller层方法执行前做的事情
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //检查session域中有没有用户信息
        EbUser user = (EbUser) session.getAttribute("user");
        if (user == null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        //true放行
        return true;
    }
    //在preHandle方法返回true后，在Controller层方法执行后，渲染视图之前做的事情
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //在preHandle方法返回true后，整个请求完成后执行，一般用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
