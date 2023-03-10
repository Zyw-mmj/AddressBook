package cn.bistu.controller;

import cn.bistu.dao.impl.ContactDaoMySQLImpl;
import cn.bistu.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "LoginServlet",urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
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
        result=dom.login(userID,password);
        if(result==1){
            request.getSession().setAttribute("ID",userID);
            classes= dom.findClass(userID);
            name= dom.findName(userID);
            request.getSession().setAttribute("Class",classes);
            request.getSession().setAttribute("Name",name);
            response.sendRedirect("/ListMyContactServlet");
        }

        else {
            response.sendRedirect("/face.jsp?error=yes");
        }
    }
}
