package cn.bistu.servlet;

import cn.bistu.entity.Contact;
import cn.bistu.exception.NameRepeatException;
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

@WebServlet(name = "AddContactServlet",urlPatterns = {"/AddContactServlet"})
public class AddContactServlet extends HttpServlet {    //管理员
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.接收参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");
        String classes=request.getParameter("class");
        String pwd=request.getParameter("password");
        String password= null;
        try {
            password = MD5.md5(pwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //封装成Contact对象
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setGender(gender);
        contact.setAge(age);
        contact.setPhone(phone);
        contact.setEmail(email);
        contact.setQq(qq);
        contact.setPassword(password);
        contact.setClasses(classes);
        ContactService service = new ContactServiceImpl();
        //2.调用dao类的添加联系人方法
        try {
            service.addContact(contact);
        } catch (NameRepeatException e) {
            //处理自定义业务异常
            request.setAttribute("message",e.getMessage());
            request.getRequestDispatcher("/index2.jsp").forward(request,response);
            return;
        }
        //3.跳转到查询联系人页面
        response.sendRedirect(request.getContextPath()+"/ListContactServlet");
    }
}
