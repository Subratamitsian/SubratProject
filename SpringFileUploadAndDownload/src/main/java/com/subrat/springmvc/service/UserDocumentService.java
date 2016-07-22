package com.subrat.springmvc.service;

import java.util.List;

import com.subrat.springmvc.model.UserDocument;

public interface UserDocumentService {
	UserDocument findById(int id);
	 
    List<UserDocument> findAll();
     
    List<UserDocument> findAllByUserId(int id);
     
    void saveDocument(UserDocument document);
     
    void deleteById(int id);
}
