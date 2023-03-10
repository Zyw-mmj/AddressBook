package cn.bistu.controller;

import cn.bistu.dao.impl.ContactDaoMySQLImpl;
import cn.bistu.entity.Contact;
import cn.bistu.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "RegistServlet",urlPatterns={"/RegistServlet"})
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String name,userID,password = null,gender,Class,phone,pwd;
        boolean a;
        ContactDaoMySQLImpl dom=new ContactDaoMySQLImpl();
        request.setCharacterEncoding("utf-8");
        name=request.getParameter("name");
        gender=request.getParameter("gender");
        userID=request.getParameter("userID");
        pwd=request.getParameter("password");
        try {
            password= MD5.md5(pwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Class=request.getParameter("Class");
        phone=request.getParameter("phone");

        if(dom.checkID(userID)){
            response.sendRedirect(request.getContextPath()+"/regist.jsp?error=yes");
        }else {
            Contact contact = new Contact();
            contact.setName(name);
            contact.setId(userID);
            contact.setPassword(password);
            contact.setClasses(Class);
            contact.setPhone(phone);
            contact.setGender(gender);
            a = dom.regist(contact);
            if (a) {
                request.getRequestDispatcher("/face.jsp?succeed=yes").forward(request,response);
            } else {
                System.out.println("注册失败");
            }
        }


    }
}
