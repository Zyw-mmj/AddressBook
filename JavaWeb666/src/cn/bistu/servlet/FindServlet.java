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

@WebServlet(name = "FindServlet",urlPatterns = {"/FindServlet"})
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ContactService service = new ContactServiceImpl();
        request.setCharacterEncoding("utf-8");
        List<Contact> list = service.findByName(request.getParameter("name"));
        //把结果集保存到域对象
        request.setAttribute("theInformation",list);
        //跳转到jsp页面
        request.getRequestDispatcher("/showFind.jsp").forward(request,response);
    }

}
