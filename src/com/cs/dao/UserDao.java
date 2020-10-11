package com.cs.dao;

import com.cs.entity.User;

import java.util.List;

public interface UserDao {

    //查询数据的总记录数
    public int findByCountUser()throws Exception;

    //分页方法
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception;
    //查看当前信息
    public User findbycrrunt(int id) throws  Exception;
    //删除当前信息
    public int deletinfoid(int id)throws  Exception;
    //添加信息
   public  int add(User us)throws  Exception;
    //修改
    public  int update(User us)throws Exception;

}
