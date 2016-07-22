package com.subrat.springmvc.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.subrat.springmvc.dao.AbstractDao;
import com.subrat.springmvc.dao.UserDocumentDao;
import com.subrat.springmvc.model.UserDocument;

@Repository("userDocumentDao")
public class UserDocumenDaoImpl extends AbstractDao<Integer, UserDocument> implements UserDocumentDao {

	@SuppressWarnings("unchecked")
	public List<UserDocument> findAll() {
	Criteria criteria= createEntityCriteria();
	return (List<UserDocument>)criteria.list();
	}

	public UserDocument findById(int id) {
		return getByKey(id);
	}

	public void save(UserDocument doc) {
		persist(doc);
	}

	@SuppressWarnings("unchecked")
	public List<UserDocument> findAllByUserId(int userId) {
		Criteria crit= createEntityCriteria();
		Criteria userCirt= crit.createCriteria("user");
		userCirt.add(Restrictions.eq("id",userId));
		return (List<UserDocument> )crit.list();
	}

	public void deleteById(int id) {
		UserDocument userDoc= getByKey(id);
		delete(userDoc);
	}

}
