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

@WebServlet(name = "EditMyServlet",urlPatterns = {"/EditMyServlet"})
public class EditMyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.接受参数
        String id = (String) request.getSession().getAttribute("ID");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");


        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setGender(gender);
        contact.setAge(age);
        contact.setPhone(phone);
        contact.setEmail(email);
        contact.setQq(qq);


        ContactService service = new ContactServiceImpl();
        service.updateMyInformation(contact);


        response.sendRedirect(request.getContextPath()+"/ListMyContactServlet");
    }
}
