package cn.test.lms.Interceptor;

import cn.test.lms.bean.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        System.out.println("进入权限拦截器");
        HttpSession session = request.getSession();
        TbUser user = (TbUser) session.getAttribute("user");
        //先判断是否有用户登陆
        if (user==null){
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        String uri = request.getServletPath();
//        System.out.println(uri);
        //图书管理权限
        if (uri.equals("/add_book")||uri.equals("/book_list")||uri.equals("/category_list")){
            if (user.getBookSet().equals("0")){
                request.getRequestDispatcher("/error").forward(request,response);return false;
            }else {
                return true;
            }
        }
        //读者管理权限
        if (uri.equals("/add_reader")||uri.equals("/reader_list")){
            if (user.getReaderSet().equals("0")){
                request.getRequestDispatcher("/error").forward(request,response);return false;
            }else {
                return true;
            }
        }
        //图书借还权限
        if (uri.equals("/borrow_book")||uri.equals("/return_book")){
            if (user.getBorrowSet().equals("0")){
                request.getRequestDispatcher("/error").forward(request,response);return false;
            }else {
                return true;
            }
        }
        //系统查询权限
        if (uri.equals("/record_list")||uri.equals("/over_record_list")||uri.equals("reader_ranking")||uri.equals("book_ranking")){
            if (user.getSearchSet().equals("0")){
                request.getRequestDispatcher("/error").forward(request,response);return false;
            }else {
                return true;
            }
        }
        //系统管理权限
        if (uri.equals("/admin_list")){
            if (user.getSystemSet().equals("0")){
                request.getRequestDispatcher("/error").forward(request,response);return false;
            }else {
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
