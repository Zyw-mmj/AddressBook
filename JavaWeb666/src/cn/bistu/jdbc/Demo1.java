package cn.bistu.jdbc;

import cn.bistu.util.JdbcUtil;
import java.sql.Connection;

/**
 * jdbc连接数据库
 */
public class Demo1 {
    //连接数据库的URL
    /*private String url = "jdbc:mysql://127.0.0.1:3306/test";
    private String user = "root";//用户名
    private String password = "123456";//密码*/

    /**
     * 第一种办法
     * @throws Exception
     */
   /* @Test
    public void test1() throws Exception{
        //1.创建驱动程序类对象
        Driver driver = new com.mysql.jdbc.Driver();
        //设置用户名和密码
        Properties props = new Properties();
        props.setProperty("user",user);
        props.setProperty("password",password);
        //2. 连接数据库
        Connection conn = driver.connect(url,props);

        System.out.println(conn);
    }*/
    /**
     * 使用驱动管理器连接数据库
     *
     */


}
