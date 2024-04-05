package com.OOZone.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TheServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理 GET 请求
        response.setContentType("text/html");
        response.getWriter().println("Hello, world!");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理 POST 请求
        // 可以在这里进行一些请求处理，例如获取请求参数、处理表单数据等
    }
}