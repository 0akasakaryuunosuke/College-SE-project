package com.OOZone.listeners;
/*监听器*/
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
public class TheListener implements ServletContextListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 应用程序启动时调用
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 应用程序关闭时调用
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // 可以在这里进行一些属性添加的监听
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // 可以在这里进行一些属性删除的监听
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // 可以在这里进行一些属性替换的监听
    }

    /*@Override
    public void init() throws ServletException {
        // Servlet 初始化时调用
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 可以在这里进行一些请求处理
    }
    @Override
    public void destroy() {
        // Servlet 关闭时调用
    }*/
}