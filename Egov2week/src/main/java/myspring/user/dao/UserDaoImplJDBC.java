package myspring.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

//mybatis 를 이용할경우 jdbc 방식은 주석처리
//@Repository("userDao")
public class UserDaoImplJDBC implements UserDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	class UserMapper implements RowMapper<UserVO>{

		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setUserid(rs.getString("userid"));
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			return user;
		}

		public int insertUser(UserVO user) {
			// TODO Auto-generated method stub
			return 0;
		}

		public List<UserVO> selectUserList() {
			// TODO Auto-generated method stub
			return null;
		}

		public int deleteUser(String id) {
			// TODO Auto-generated method stub
			return 0;
		}

		public int updateUser(UserVO user) {
			// TODO Auto-generated method stub
			return 0;
		}

		public UserVO selectUserById(String id) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public int insert(UserVO user) {
		int result = 0;
		String sql = "insert into users values(?,?,?,?)";
		result = jdbcTemplate.update(sql,user.getUserid(),user.getName(),user.getGender(),user.getCity());
		
		System.out.println("등록된 UserId = " + user.getUserid() + " Name = " + user.getName());
		return result;
	}

	public List<UserVO> readAll() {
		String sql = "select * from users";
		List<UserVO> userList = jdbcTemplate.query(sql,new UserMapper());
		return userList;
	}

	public int delete(String id) {
		int result = 0;
		String sql = "delete from users where userid = ?";
		result = jdbcTemplate.update(sql,id);
		System.out.println("삭제된 UserId = " + id);
		return result;
	}

	public int update(UserVO user) {
		int result = 0;
		String sql = "update users set name=?,gender=?,city=? where userid=?";
		result = jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getCity(),user.getUserid());
		System.out.println("수정된 UserId = " + user.getUserid());
		return result;
	}
	public UserVO read(String id) {
		
		String sql = "select * from users where userid=?;";
		try {
			UserVO user = jdbcTemplate.queryForObject(sql,new Object[] {id},new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}

	}

}
