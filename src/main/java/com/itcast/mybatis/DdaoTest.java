package com.itcast.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itcast.ddao.UserDao;
import com.itcast.ddao.UserDaoImpl;
import com.itcast.pojo.User;

public class DdaoTest {

	@Test
	public void ddaoTest() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		UserDao userDao = new UserDaoImpl(sessionFactory);
		User user = userDao.findUserById(10);
		System.out.println(user);
	}
}
