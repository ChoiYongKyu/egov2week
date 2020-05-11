package myspring.user.dao;

import java.util.List;

import myspring.user.vo.UserVO;

@MyMapper
public interface UserMapper {
	UserVO selectUserById(String id);
	List<UserVO> selectUserList();
	int insertUser(UserVO userVO);
	int updateUser(UserVO userVO);
	int deleteUser(String id);
}
