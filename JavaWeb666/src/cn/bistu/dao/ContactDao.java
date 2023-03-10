package cn.bistu.dao;

import cn.bistu.entity.Contact;

import java.util.List;

/**
 * 联系人的DAO接口
 */
public interface ContactDao {
    public void addContact(Contact contact);    //添加联系人
    public void updateContact(Contact contact); //修改联系人
    public void deleteContact(String id);   //删除联系人
    public List<Contact> findAll(); //查询所有联系人
    public Contact findById(String id); //根据编号查询联系人
    public boolean checkContact(String name);   //根据姓名查询是否重复
    public List<Contact> findByClass(String classes,String id);
    public String findClass(String id);
    public void updateMyInformation(Contact contact);
    public void deleteSome(String ids);
    public List<Contact> findByName(String name);
    public boolean checkPwd(String id,String pwd);
    public void updatePassword( String id,String pwd);

}
