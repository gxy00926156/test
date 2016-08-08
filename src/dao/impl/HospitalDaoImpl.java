package dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;






import bean.Hospital;
import dao.HospitalDao;

public class HospitalDaoImpl extends Impl implements HospitalDao {
	@Resource
	private SessionFactory sessionFactory;
	HibernateTemplate hibernateTemplate;

	public HospitalDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Hospital t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(Hospital t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public Hospital findById(String p) {
		Hospital temp = (Hospital) getSession().get(Hospital.class, Integer.parseInt(p));
		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> findAll() {
		List<Hospital> list = new ArrayList<Hospital>();
		list = getHibernateTemplate().find("from Hospital");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> find() {
		List<Hospital> list = new ArrayList<Hospital>();
		list = getHibernateTemplate().find("from Hospital");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (Hospital hospital : list) {
			map.put(hospital.getHospital(), Integer.valueOf(hospital.getId()));
		}
		File file2 = new File("D:/doctor/doctor/doctorlist.txt");
		File file1 = new File("D:/doctor/doctor/doctors.txt");
		BufferedReader reader = null;
		FileOutputStream out = null;
		PrintStream p = null;
		if (!file2.exists()) {
			try {
				file2.createNewFile();
				out = new FileOutputStream(file2);
				p = new PrintStream(out);
				reader = new BufferedReader(new FileReader(file1));
				String tempString = "";
				while ((tempString = reader.readLine()) != null) {
					String[] temp = tempString.split("\t");
					Integer id = map.get(temp[2]);
					if (id != null) {
						String line = tempString + "\t" + id.toString();
//						System.out.println(line);
						p.print(line);
						p.println();
					}else{
						System.out.println(temp[2]);
						continue;
					}
				}
				reader.close();
				p.close();
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Hospital> change() {
		sessionFactory = getSessionFactory();
		Session session = getSession();
		Criteria crit = session.createCriteria(Hospital.class);
		crit.add(Restrictions.like("hospital", "%%（%%"));
		List<Hospital> results = new ArrayList<Hospital>();
		results = crit.list();

		for (Hospital result : results) {

			Transaction tx = session.beginTransaction();

			String name = result.getHospital();
			System.out.println(name);
			String temp[] = name.split("（");
			String temp2[] = temp[1].split("）");
			System.out.println(temp2.length);
			if (temp2.length > 1) {
				continue;
			}
			try {
				getHibernateTemplate().delete(result);
				name = temp[0];
				Hospital hh = new Hospital();
				hh.setHospital(name);
				hh.setAddress(result.getAddress());
				hh.setGoodat(result.getGoodat());
				hh.setLevel(result.getLevel());
				hh.setProvince(result.getProvince());
				hh.setRating(result.getRating());
				hh.setType(result.getType());
				System.out.println(hh);
				getHibernateTemplate().save(hh);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}

		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public java.util.Map<String, Hospital> select() {
		List<Hospital> list = new ArrayList<Hospital>();
		list = getHibernateTemplate().find("from Hospital");
		HashMap<String, Hospital> map = new HashMap<String, Hospital>();
		for (Hospital hospital : list) {
			map.put(hospital.getHospital(),hospital);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void rating() {
		List<Hospital> list = new ArrayList<Hospital>();
		list = getHibernateTemplate().find("from Hospital");
		for(Hospital hospital:list){
			
			switch (hospital.getLevel()) {
			case "三级甲等":
				hospital.setRating(9);
				break;
			case "三级乙等":
				hospital.setRating(8);
				break;
			case "三级丙等":
				hospital.setRating(7);
				break;
			case "二级甲等":
				hospital.setRating(6);
				break;
			case "二级乙等":
				hospital.setRating(5);
				break;
			case "二级丙等":
				hospital.setRating(4);
				break;
			case "一级甲等":
				hospital.setRating(3);
				break;
			case "一级乙等":
				hospital.setRating(2);
				break;
			case "一级丙等":
				hospital.setRating(1);
				break;
			default:
				hospital.setRating(0);
				break;
			}
			System.out.println(hospital);
			getHibernateTemplate().update(hospital);
		}
	}

	

}
