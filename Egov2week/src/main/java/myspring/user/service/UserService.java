package myspring.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import myspring.user.vo.UserVO;

@Transactional(rollbackFor = {Exception.class})
public interface UserService {
	int insertUser(UserVO user);
	List<UserVO> getUserList();
	int deleteUser(String id);
	UserVO getUser(String id);
	int updateUser(UserVO user);
}
