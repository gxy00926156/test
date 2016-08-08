package doctorServer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;
import dao.UserDao;

public class UserJunit {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserDao dao = (UserDao) context.getBean("userDao");
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsert() {
		User t = new User();
		t.setName("admin");
		t.setPassword("admin");
		dao.insert(t);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		User user = dao.findById("1");
		System.out.println(user);
	}

	@Test
	public void testFindAll() {
		List<User> list = dao.findAll();
		for(User user:list){
			System.out.println(user);
		}
	}

}
