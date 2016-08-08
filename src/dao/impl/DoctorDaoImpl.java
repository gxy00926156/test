package dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import bean.Doctor;
import dao.DoctorDao;


public class DoctorDaoImpl extends Impl implements DoctorDao {

	public DoctorDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Doctor t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(Doctor t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public Doctor findById(String p) {
		Doctor temp = (Doctor) getSession().get(Doctor.class,
				Integer.parseInt(p));
		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> findAll() {
		Criteria crit = getSession().createCriteria(Doctor.class);
		List<Doctor> list = crit.list();
		return list;
	}


	@Override
	public List<Doctor> getDoctorByDepart(String province, String department,
			boolean isde) {
		return null;

	}

	public List<Doctor> getDoctorByDepart(String province, String department,
			String disease) {
		return null;

	}

	public MWNumericArray getArray(List<Doctor> list) {
		return null;

	}


	@Override
	public List<Doctor> getDoctorByDisease(String area, String disease,
			boolean isde) {
		return null;
	}

	

	@Override
	public List<Doctor> SortList(List<Doctor> doctors, double[] w) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void CaRating() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTitleId() {
		// TODO Auto-generated method stub
		
	}
}
