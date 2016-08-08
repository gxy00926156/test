package doctorServer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Hospital;
import dao.HospitalDao;

public class HospitalJunit {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	HospitalDao dao = (HospitalDao) context.getBean("hospitalDao");
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		System.out.println(dao.findById("1024"));
	}

	@Test
	public void testFindAll() {
		List<Hospital> list = dao.findAll();
		for(Hospital temp:list){
			System.out.println(temp);
		}
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

}
