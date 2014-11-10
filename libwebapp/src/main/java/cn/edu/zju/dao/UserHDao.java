package cn.edu.zju.dao;

import org.springframework.stereotype.Repository;

import cn.edu.zju.entity.User;

@Repository("userDao")
public class UserHDao extends HbBaseDao<User> implements UserDao {

}
