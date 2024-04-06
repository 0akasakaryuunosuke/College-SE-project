package com.OOZone.servlets;

import com.OOZone.util.CodeUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/codeservlet")
public class codeservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成验证码，并把验证码输出到响应输出流，响应给浏览器，同时返回一个需要服务器存储的字符验证码以便与请求携带的验证码对比，实现注册验证
        String vericode=CodeUtils.outputVerifyImage(150,50,response.getOutputStream(),4);
        //如果验证码需要在服务器校验就需要存储
        request.getSession().setAttribute("vericode",vericode);
    }
}