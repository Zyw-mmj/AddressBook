package cn.bistu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test {
    public static void main(String[] args) throws Exception {
//        //注册驱动
//        //mysql5.5以后可以不写，mysql8.0得加上cj
//        Class.forName("com.mysql.jdbc.Driver");
//        //获取数据库连接
//        //mysql8.0得加上时区时间(?serverTimezone=UTC)
//        //本地数据库可以省略IP地址和端口号
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306//test?serverTimezone=UTC", "root", "123456");
//        String sql = "create table abc;";
//        //获取执行sql的对象
//        Statement stmt = conn.createStatement();
//        //执行sql的对象
//        int count = stmt.executeUpdate(sql);
//        //处理结果
//        System.out.println(count);
//        //释放资源
//        stmt.close();
//        conn.close();
        String driverName="com.mysql.cj.jdbc.Driver";
        String url1="jdbc:mysql://localhost:3306/z2020011737";
        String url2="?use=root&password=123456";
        String url3="&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String url=url1+url2;
        String userName="root";
        String userPwd="123456";
        try{
            Class.forName(driverName);
            Connection con=DriverManager.getConnection(url,userName,userPwd);
            System.out.println("连接成功");
//            Statement statement= (Statement) con.createStatement();
            String sql="select* from telbook;";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery(sql);
            String name,age,id,gender;
            while (resultSet.next()){
                name=resultSet.getString("name");
                age=resultSet.getString("age");
                id=resultSet.getString("id");
                gender=resultSet.getString("gender");
                System.out.println("姓名："+name);
                System.out.println("年龄："+age);
                System.out.println("ID："+id);
                System.out.println("性别："+gender);
            }
            resultSet.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("连接失败");
        }
    }

}
