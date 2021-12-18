package site.gamsung.service.user.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import site.gamsung.service.domain.User;
import site.gamsung.service.user.UserDAO;

@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessioTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	///Constructor
	public UserDAOImpl() {
		System.out.println(this.getClass());
	}

	///Method
	@Override
	public void addUser(User user) throws Exception {
		sqlSession.insert("UserMapper.addUser", user);
	}

	@Override
	public User getUser(String id) throws Exception {
		return sqlSession.selectOne("UserMapper.getUser", id);
	}

	@Override
	public void updateUser(User user) throws Exception {
		sqlSession.update("UserMapper.updateUser", user);
		
	}

}