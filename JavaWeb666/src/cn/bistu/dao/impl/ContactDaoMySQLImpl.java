package cn.bistu.dao.impl;

import cn.bistu.dao.ContactDao;
import cn.bistu.entity.Contact;
import cn.bistu.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoMySQLImpl implements ContactDao{
    @Override
    public void addContact(Contact contact) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "INSERT INTO telbook(NAME,gender,id,class,age,phone,email,qq,password) VALUES(?,?,?,?,?,?,?,?,?)";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,contact.getName());
            stmt.setString(2,contact.getGender());
            stmt.setString(3,contact.getId());
            stmt.setString(4,contact.getClasses());
            stmt.setString(5,contact.getAge());
            stmt.setString(6,contact.getPhone());
            stmt.setString(7,contact.getEmail());
            stmt.setString(8,contact.getQq());
            stmt.setString(9,contact.getPassword());

            //执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    @Override
    public void updateContact(Contact contact) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "UPDATE telbook SET NAME=?,gender=?,id=?,class=?,age=?,phone=?,email=?,qq=? WHERE id=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,contact.getName());
            stmt.setString(2,contact.getGender());
            stmt.setString(3,contact.getId());
            stmt.setString(4,contact.getClasses());
            stmt.setString(5,contact.getAge());
            stmt.setString(6,contact.getPhone());
            stmt.setString(7,contact.getEmail());
            stmt.setString(8,contact.getQq());
            stmt.setString(9,contact.getId());

            //执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    @Override
    public void deleteContact(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "DELETE FROM telbook WHERE id=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,id);

            //执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }

    }

    @Override
    public List<Contact> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            //获取连接
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook";

            //创建PreparedStatement
            stmt = conn.prepareStatement(sql);

            //执行
            rs = stmt.executeQuery();
            List<Contact> list = new ArrayList<Contact>();
            while(rs.next()){
                Contact c = new Contact();
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getString("gender"));
                c.setAge(rs.getString("age"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setQq(rs.getString("qq"));
                c.setClasses(rs.getString("class"));
                c.setPassword(rs.getString("password"));
                list.add(c);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.close(conn, stmt ,rs);
        }
    }

    @Override
    public Contact findById(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook WHERE id=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,id);

            //执行
            rs = stmt.executeQuery();
            Contact contact = null;
            while (rs.next()){
                contact = new Contact();
                contact.setId(rs.getString("id"));
                contact.setName(rs.getString("name"));
                contact.setGender(rs.getString("gender"));
                contact.setAge(rs.getString("age"));
                contact.setPhone(rs.getString("phone"));
                contact.setEmail(rs.getString("email"));
                contact.setQq(rs.getString("qq"));
                contact.setClasses(rs.getString("class"));
                contact.setPassword(rs.getString("password"));
            }
            return contact;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    @Override
    public boolean checkContact(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook WHERE name=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,name);

            //执行
            rs = stmt.executeQuery();
            if (rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    @Override
    public List<Contact> findByClass(String classes,String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            //获取连接
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook where class=? and id!=?";

            //创建PreparedStatement
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,classes);
            stmt.setString(2,id);

            //执行
            rs = stmt.executeQuery();
            List<Contact> list = new ArrayList<Contact>();
            while(rs.next()){
                Contact c = new Contact();
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getString("gender"));
                c.setAge(rs.getString("age"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setQq(rs.getString("qq"));
                list.add(c);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.close(conn, stmt ,rs);
        }
    }

    public List<Contact> findByName(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            //获取连接
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook where name like ? ";

            //创建PreparedStatement
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,"%"+name+"%");

            //执行
            rs = stmt.executeQuery();
            List<Contact> list = new ArrayList<Contact>();
            while(rs.next()){
                Contact c = new Contact();
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getString("gender"));
                c.setAge(rs.getString("age"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setQq(rs.getString("qq"));
                list.add(c);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.close(conn, stmt ,rs);
        }
    }

    @Override
    public boolean checkPwd(String id, String pwd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook WHERE id=? and password=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,id);
            stmt.setString(2,pwd);

            //执行
            rs = stmt.executeQuery();
            if (rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    @Override
    public void updatePassword(String id, String pwd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "UPDATE telbook SET password=? WHERE id=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,pwd);
            stmt.setString(2,id);

            //执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    public int login(String userID,String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int result=0;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "select count(*) from telbook where id=? and password=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,userID);
            stmt.setString(2,password);
            //执行
            rs = stmt.executeQuery();
            while (rs.next()){
                result=rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }

        return result;
    }

    public int login2(String userID,String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int result=0;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "select count(*) from manager where id=? and password=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,userID);
            stmt.setString(2,password);
            //执行
            rs = stmt.executeQuery();
            while (rs.next()){
                result=rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }

        return result;
    }

    public boolean regist(Contact contact) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "INSERT INTO telbook(name,id,password,gender,class,phone) VALUES(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getId());
            statement.setString(3, contact.getPassword());
            statement.setString(4, contact.getGender());
            statement.setString(5, contact.getClasses());
            statement.setString(6, contact.getPhone());

            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection, statement);
        }

    }
    public String findClass(String id){
        Connection conn = null;
        PreparedStatement stmt = null;
        String classes=null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook WHERE id=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,id);

            //执行
            rs = stmt.executeQuery();
            Contact contact = null;
            while (rs.next()){
                contact = new Contact();
                contact.setId(rs.getString("id"));
                contact.setName(rs.getString("name"));
                contact.setGender(rs.getString("gender"));
                contact.setAge(rs.getString("age"));
                contact.setPhone(rs.getString("phone"));
                contact.setEmail(rs.getString("email"));
                contact.setQq(rs.getString("qq"));
                contact.setClasses(rs.getString("class"));
            }
            return contact.getClasses();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }
    public String findName(String id){
        Connection conn = null;
        PreparedStatement stmt = null;
        String classes=null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook WHERE id=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,id);

            //执行
            rs = stmt.executeQuery();
            Contact contact = null;
            while (rs.next()){
                contact = new Contact();
                contact.setId(rs.getString("id"));
                contact.setName(rs.getString("name"));
                contact.setGender(rs.getString("gender"));
                contact.setAge(rs.getString("age"));
                contact.setPhone(rs.getString("phone"));
                contact.setEmail(rs.getString("email"));
                contact.setQq(rs.getString("qq"));
                contact.setClasses(rs.getString("class"));
            }
            return contact.getName();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }
    public void updateMyInformation(Contact contact) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "UPDATE telbook SET NAME=?,gender=?,age=?,phone=?,email=?,qq=? WHERE id=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
//            String id = UUID.randomUUID().toString().replace("-","");
            //设置参数
            stmt.setString(1,contact.getName());
            stmt.setString(2,contact.getGender());
            stmt.setString(3,contact.getAge());
            stmt.setString(4,contact.getPhone());
            stmt.setString(5,contact.getEmail());
            stmt.setString(6,contact.getQq());
            stmt.setString(7,contact.getId());

            //执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }



    public boolean checkID(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook WHERE id=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,id);

            //执行
            rs = stmt.executeQuery();
            if (rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }
    public boolean checkKey(String userID,String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();

            String sql = "SELECT * FROM telbook WHERE id=? and password=? and KeyPoint=?";

            //创建PrepareStatement
            stmt = conn.prepareStatement(sql);
            //设置参数
            stmt.setString(1,userID);
            stmt.setString(2,password);
            stmt.setString(3,"yes");
            //执行
            rs = stmt.executeQuery();
            if (rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    public void deleteSome(String ids){
        Connection conn = null;
        PreparedStatement stmt = null;
        String[] IDS=ids.split(" ");
        try {
            conn = JdbcUtil.getConnection();
            String sql = "DELETE FROM telbook WHERE id=?";
            stmt = conn.prepareStatement(sql);
            if(IDS.length>0){
                for (int i=0;i< IDS.length;i++){
                    stmt.setString(1,IDS[i]);
                    stmt.addBatch();
                }
            }
            //执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }


}
