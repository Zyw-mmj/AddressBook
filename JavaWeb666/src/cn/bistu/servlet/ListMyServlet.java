package cn.bistu.servlet;

import cn.bistu.entity.Contact;
import cn.bistu.service.ContactService;
import cn.bistu.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ListMyServlet",urlPatterns = {"/ListMyServlet"})
public class ListMyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //直接调用service接口的findAll方法
        ContactService service = new ContactServiceImpl();
        List<Contact> list = Collections.singletonList(service.findById((String) request.getSession().getAttribute("ID")));
        //把结果集保存到域对象
        request.setAttribute("myInformation",list);

        //跳转到jsp页面
        request.getRequestDispatcher("/editMy.jsp").forward(request,response);
    }


}
