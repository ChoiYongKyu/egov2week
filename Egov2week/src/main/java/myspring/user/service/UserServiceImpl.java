package myspring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.user.dao.UserDao;
import myspring.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	public int insertUser(UserVO user) {
		return dao.insert(user);
	}

	public List<UserVO> getUserList() {
		return dao.readAll();
	}

	public int deleteUser(String id) {
		return dao.delete(id);
	}

	public UserVO getUser(String id) {
		UserVO user = dao.read(id);
		return user;
	}

	public int updateUser(UserVO user) {
		return dao.update(user);
	}

}
