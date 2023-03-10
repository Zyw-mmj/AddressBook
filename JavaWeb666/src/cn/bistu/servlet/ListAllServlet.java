package cn.bistu.servlet;

import cn.bistu.entity.Contact;
import cn.bistu.service.ContactService;
import cn.bistu.service.impl.ContactServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "ListAllServlet",urlPatterns={"/ListAllServlet"})
public class ListAllServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactService service = new ContactServiceImpl();
        List<Contact> list = service.finaAll();
        request.setAttribute("contacts",list);
        request.getRequestDispatcher("/listInformation.jsp" ).forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
