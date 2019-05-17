package com.itcast.ddao;

import com.itcast.pojo.User;

//com.itcast.ddao中是原始Dao开发方式。

public interface UserDao {

	public User findUserById (int id) throws Exception;
}
