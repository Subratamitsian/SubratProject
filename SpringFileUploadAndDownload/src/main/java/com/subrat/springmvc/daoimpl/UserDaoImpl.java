package com.subrat.springmvc.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.subrat.springmvc.dao.AbstractDao;
import com.subrat.springmvc.dao.UserDao;
import com.subrat.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao{

	public User findById(int id) {
		User user= getByKey(id);
		return user;
	}

	public User findBySSO(String sso) {
		System.out.println("SSO of the user is :- "+sso);
		Criteria crit= createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user=(User) crit.uniqueResult();
		return user;
	}

	public void save(User user) {
		persist(user);		
	}

	public void deleteBySSO(String sso) {

		Criteria crit= createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user=(User) crit.uniqueResult();
		delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria crit= createEntityCriteria().addOrder(Order.asc("firstName"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<User>)crit.list();
	}

}
