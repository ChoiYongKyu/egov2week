package myspring.user.dao;

import java.util.List;

import javax.sql.DataSource;

import myspring.user.vo.UserVO;

public interface UserDao {
	int insert(UserVO user);
	List<UserVO> readAll();
	int delete(String id);
	int update(UserVO user);
	UserVO read(String id);
}
