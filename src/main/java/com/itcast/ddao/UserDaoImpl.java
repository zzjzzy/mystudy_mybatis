package com.itcast.ddao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itcast.pojo.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sessionFactory;

	//将sqlsessionfactory通过构造函数注入
	public UserDaoImpl(SqlSessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public User findUserById(int id) throws Exception{
		//sqlsession线程不安全，在方法体内使用sqlsession
		SqlSession session = sessionFactory.openSession();
		User user = session.selectOne("test.findUserById",id);
		session.close();
		return user;
	}

}
