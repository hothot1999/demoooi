package com.cs.service;

import com.cs.entity.User;

import java.util.List;

public interface UserService {

    //查询数据的总记录数
    public int findByCountUser()throws Exception;

    //分页方法
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception;
    //查询当前ID信息
    public User findbycrrunt(int id) throws  Exception;
    //删除当前信息
    public boolean deletinfoid(int id)throws  Exception;
    //添加信息
    public  boolean add(User us)throws  Exception;
    //修改
    public  boolean update(User us)throws Exception;

}
