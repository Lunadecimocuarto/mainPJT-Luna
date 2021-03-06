package site.gamsung.service.user.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import site.gamsung.service.common.Search;
import site.gamsung.service.domain.User;
import site.gamsung.service.user.UserDAO;

@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
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

	@Override
	public List<User> listUser(Search search) throws Exception {
		return sqlSession.selectList("UserMapper.listUser", search);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {

		return sqlSession.selectOne("UserMapper.getTotalCount", search);
	}

	@Override
	public String checkDuplication(User user) throws Exception {
		
		return sqlSession.selectOne("UserMapper.checkDuplication", user);
	}

	@Override
	public void addLoginDate(User user) throws Exception {
		
		sqlSession.insert("UserMapper.addLoginDate", user);
	}

	@Override
	public String getSaltById(String id) throws Exception {
		
		return sqlSession.selectOne(id);
	}

	@Override
	public String findId(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne("UserMapper.findId", map);
	}

	@Override
	public void addSuspensionUser(User user) throws Exception {
		sqlSession.insert("UserMapper.addSusepsionUser", user);
		
	}

	@Override
	public void addSecessionUser(User user) throws Exception {
		sqlSession.insert("UserMapper.addSecessionUser", user);
		
	}

	@Override
	public void addDormantUser(User user) throws Exception {
		sqlSession.insert("UserMapper.addDormantUser", user);	
	}

	@Override
	public void updateDormantGeneralUserConver(String id) throws Exception {
		sqlSession.insert("UserMapper.updateDormantGeneralUserConver", id);
		
	}

}
