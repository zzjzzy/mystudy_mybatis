package com.itcast.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itcast.dao.UserDao;
import com.itcast.pojo.User;

public class DaoTest {
	
	@Test
	public void daoTest() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = new User();
		user.setUsername("李五");
		userDao.add(user);
		sqlSession.commit();
		System.out.println(user);
//		User user = userDao.findUserById(1);
//		System.out.println(user);
	}
}
