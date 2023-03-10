package cn.bistu.service;

import cn.bistu.entity.Contact;
import cn.bistu.exception.NameRepeatException;

import java.util.List;

public interface ContactService {
    public void addContact(Contact contact) throws NameRepeatException;
    public void updateContact(Contact contact);
    public void deleteContact(String id);
    public List<Contact> finaAll();
    public Contact findById(String id);
    public List<Contact>findByClass(String classes, String id);
    public String findClasses(String id);
    public void updateMyInformation( Contact contact);
    public void deleteSome(String[] ids);
    public boolean checkPwd(String id,String pwd);
    public List<Contact>findByName(String name);
    public void updatePassword( String id,String pwd);
}
