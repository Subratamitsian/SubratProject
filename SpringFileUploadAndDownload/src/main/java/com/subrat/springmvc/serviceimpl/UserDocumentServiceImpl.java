package com.subrat.springmvc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrat.springmvc.dao.UserDocumentDao;
import com.subrat.springmvc.model.UserDocument;
import com.subrat.springmvc.service.UserDocumentService;

@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl implements UserDocumentService{
	
	@Autowired
	UserDocumentDao userDocDao;

	public UserDocument findById(int id) {
		return userDocDao.findById(id);
	}

	public List<UserDocument> findAll() {
		return userDocDao.findAll();
	}

	public List<UserDocument> findAllByUserId(int id) {
		return userDocDao.findAllByUserId(id);
	}

	public void saveDocument(UserDocument document) {
		userDocDao.save(document);
	}

	public void deleteById(int id) {
		userDocDao.deleteById(id);
	}

}
