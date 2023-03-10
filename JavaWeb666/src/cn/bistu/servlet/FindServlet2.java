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
import java.util.List;

@WebServlet(name = "FindServlet2",urlPatterns = {"/FindServlet2"})
public class FindServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService service = new ContactServiceImpl();
        request.setCharacterEncoding("utf-8");
        List<Contact> list = service.findByName(request.getParameter("name"));
        request.setAttribute("theInformation",list);
        request.getRequestDispatcher("/showFind2.jsp").forward(request,response);
    }

}
