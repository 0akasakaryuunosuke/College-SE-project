package com.OOZone.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String code=request.getParameter("vericode");

        String scode=(String) request.getSession().getAttribute("vericode");
        //判断验证码是否正确
        if (!code.equalsIgnoreCase(scode)) {
            request.setAttribute("errcode", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }else {
            //需要去查询数据库是否有相同的用户名,没有就添加至数据库，此处省略查询
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }

    }
}