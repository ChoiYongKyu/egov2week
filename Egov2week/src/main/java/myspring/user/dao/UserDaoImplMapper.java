package myspring.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.dao.UserDaoImplJDBC.UserMapper;
import myspring.user.vo.UserVO;
//DAO를 스프링에 인식시키기 위해서 주로 사용
@Repository("userDao")
public class UserDaoImplMapper implements UserDao{
	
	@Autowired
	private UserMapper userMapper;
	
	/*@Autowired
	 * session에 sqlsesscionTemplate 객체가 주입
	private SqlSession session;*/

	public int insert(UserVO user) {
		int result = 0;
		result = userMapper.insertUser(user);
		System.out.println("등록된 Mapper UserId = " + user.getUserid() + " Mapper Name = " + user.getName());
		return result;
	}

	public List<UserVO> readAll() {
		
		List<UserVO> userList = userMapper.selectUserList();
		
		// SqlSession 방법
		//List<UserVO> userList = session.selectList("userNs.selectUserList");
		return userList;
	}
	
	public int delete(String id) {
		int result = 0;
		result = userMapper.deleteUser(id);
		return result;
	}

	public int update(UserVO user) {
		int result = 0;
		result = userMapper.updateUser(user);
		return result;
	}

	public UserVO read(String id) {
		UserVO user = userMapper.selectUserById(id);
		return user;
	}

}
