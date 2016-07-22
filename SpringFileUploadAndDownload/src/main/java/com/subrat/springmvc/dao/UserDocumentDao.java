package com.subrat.springmvc.dao;

import java.util.List;

import com.subrat.springmvc.model.UserDocument;

public interface UserDocumentDao {

	public List<UserDocument> findAll();
	public UserDocument findById(int id);
	public void save(UserDocument doc);
	public List<UserDocument> findAllByUserId(int userId);
	public void deleteById(int id);
}
