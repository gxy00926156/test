package dao.impl;

import java.util.List;

import org.hibernate.Criteria;

import bean.User;
import dao.UserDao;

public class UserDaoImpl extends Impl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void insert(User t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public User findById(String p) {
		// TODO Auto-generated method stub
		User temp = (User) getSession().get(User.class, Integer.parseInt(p));
		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		Criteria crit = getSession().createCriteria(User.class);
		List<User> list = crit.list();
		return list;
	}

}
