package com.cs.service.impl;

import com.cs.dao.impl.UserDaoImpl;
import com.cs.entity.User;
import com.cs.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl udi=new UserDaoImpl();
    @Override
    public int findByCountUser() throws Exception {
        return udi.findByCountUser();
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        return udi.findByPageUserInfo(pageNo,pageSize);
    }

    @Override
    public User findbycrrunt(int id) throws Exception {
        return udi.findbycrrunt(id);
    }

    @Override
    public boolean deletinfoid(int id) throws Exception {
        int i=udi.deletinfoid(id);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean add(User us) throws Exception {
        int i=udi.add(us);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(User us) throws Exception {
        int i=udi.update(us);
        if (i<0) {
            return false;
        }
        else{
            return  true;
        }
    }

}
