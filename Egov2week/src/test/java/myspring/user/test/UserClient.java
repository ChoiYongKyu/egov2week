package myspring.user.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import myspring.user.dao.UserDao;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
			"classpath:config/data.xml",
			"classpath:config/aop.xml",
			"classpath:config/mybatisBeans.xml"})
public class UserClient {

	@Autowired
	private ApplicationContext context;
	@Autowired
	UserService service;
	
	
	// SqlSession을 이용한 방법.
	/*@Autowired
	SqlSession session;*/
	
	@Test
	@Ignore
	public void daoTest(){
		UserDao dao = context.getBean("userDao",UserDao.class);
		UserVO vo = dao.read("user1");
		System.out.println("검색 아이디 = "+ vo);
		
		try {
			/*dao.insert(new UserVO("user33","name33","3남","city35"));
			dao.update(new UserVO("user1","name1","남","city1"));
			dao.delete("user4");*/
			
			List<UserVO> list = dao.readAll();
			for (UserVO userVO : list) {
				System.out.println(userVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void configTest() {
		SqlSession session = context.getBean("sqlSession",SqlSession.class);
		UserVO user = session.selectOne("userNs.selectUserById","user1");
		System.out.println(user);
	}

	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	@Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("user12","name12","여12","city12"));
		for(UserVO user:service.getUserList()) {
			System.out.println(user);
			
		}
	}
	
	@Test
	@Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("user1","name1","남","city1"));
		
		for(UserVO user:service.getUserList()) {
			System.out.println(user);
		}
	}
	
	@Test
	@Ignore
	public void deleteUserTest() {
		service.deleteUser("user2");
		
		for(UserVO user:service.getUserList()) {
			System.out.println(user);
		}
	}
	
	@Test
	@Ignore
	public void getUserTest() {
		UserVO user = service.getUser("gildong");
		System.out.println(user);
		assertEquals("홍길동",user.getName());
	}
	
}
