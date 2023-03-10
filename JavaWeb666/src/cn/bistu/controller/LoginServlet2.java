package cn.bistu.controller;

import cn.bistu.dao.impl.ContactDaoMySQLImpl;
import cn.bistu.entity.Contact;
import cn.bistu.service.ContactService;
import cn.bistu.service.impl.ContactServiceImpl;
import cn.bistu.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@WebServlet(name = "LoginServlet2",urlPatterns={"/LoginServlet2"})
public class LoginServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String userID,pwd,password = null,name,classes;
        int result;
        ContactDaoMySQLImpl dom=new ContactDaoMySQLImpl();
        request.setCharacterEncoding("utf-8");
        userID=request.getParameter("username");
        pwd=request.getParameter("password");
        try {
            password= MD5.md5(pwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        result=dom.login2(userID,password);
        if(result==1){
            request.getSession().setAttribute("ID",userID);
            ContactService service = new ContactServiceImpl();
            List<Contact> list = service.finaAll();
            request.setAttribute("contacts",list);
            request.getRequestDispatcher("/listInformation.jsp" ).forward(request,response);
        }
        else {
            response.sendRedirect("/face2.jsp?error=yes");
        }
    }
}
