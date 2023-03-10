package cn.bistu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class createStatement {
    public PreparedStatement createstatement(String sql){
        String driverName="com.mysql.cj.jdbc.Driver";
        String url1="jdbc:mysql://localhost:3306/z2020011737";
        String url2="?use=root&password=123456";
        String url=url1+url2;
        String userName="root";
        String userPwd="123456";
        try{
            Class.forName(driverName);
            Connection con= DriverManager.getConnection(url,userName,userPwd);
//            System.out.println("连接成功");
//            Statement statement= (Statement) con.createStatement()
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            return preparedStatement;
        }catch (Exception e){
            e.printStackTrace();
//            System.out.println("连接失败");
        }
        return null;
    }
}
