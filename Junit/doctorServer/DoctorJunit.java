package doctorServer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Doctor;
import dao.DoctorDao;

public class DoctorJunit {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	DoctorDao dao =   (DoctorDao) context.getBean("doctorDao");
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsert() throws Exception {
		fail("not implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	
	public void testFindById() {
		Doctor temp = dao.findById("3");
		System.out.println(temp);
	}

	
	public void testFindAll() {
		List<Doctor> list = dao.findAll();
		for(Doctor temp:list){
			System.out.println(temp);
		}
	}
	
	@Test
	public void testGetDoctorByDepart() throws Exception {
		List<Doctor> doctors = dao.getDoctorByDepart("福建", "眼科",false);
		for(Doctor temp:doctors){
			System.out.println(temp);
		}
		double[] w = new double[]{6,9};
		List<Doctor> list = dao.SortList(doctors, w);
		for(Doctor temp:list){
			System.out.println(temp);
		}
	}
	
	
//	@Test
	public void testGetDoctorByDisease() throws Exception {
		List<Doctor> list = dao.getDoctorByDisease(null, "肝炎", true);
		for(Doctor temp:list){
			System.out.println(temp);
		}
	}
	
//	@Test
	public void testUpdateTitleId() throws Exception {
		dao.updateTitleId();
	}
	
//	@Test
	public void testCaRating() throws Exception {
		dao.CaRating();
	}
	
	

}
