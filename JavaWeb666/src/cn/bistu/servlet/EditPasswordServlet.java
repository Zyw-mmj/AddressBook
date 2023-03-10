package cn.bistu.servlet;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@WebServlet(name = "EditPasswordServlet",urlPatterns = {"/EditPasswordServlet"})
public class EditPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID,newpassword=null,oldpassword = null,oldpwd,newpwd;
        int result;
        ContactDaoMySQLImpl dom=new ContactDaoMySQLImpl();
        request.setCharacterEncoding("utf-8");
        userID=request.getParameter("theID");
        oldpwd=request.getParameter("oldPwd");
        newpwd=request.getParameter("newPwd");
        try {
            oldpassword= MD5.md5(oldpwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            newpassword=MD5.md5(newpwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        result=dom.login(userID,oldpassword);
        if(result==1){
            dom.updatePassword(userID,newpassword);
            HttpSession session = request.getSession();
            session.removeAttribute("ID");
            response.sendRedirect("/face.jsp?success=yes");
        }
        else {
            response.sendRedirect("/editPassword.jsp?error=yes");
        }
    }



    public static void main(String[] args) {
        ContactService service = new ContactServiceImpl();
        String pwd = null;
        try {
            pwd = MD5.md5("123456");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
//        boolean t =dom.checkPwd();
//        System.out.println(t);
    }
}
