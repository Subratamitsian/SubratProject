package com.subrat.springmvc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrat.springmvc.dao.UserDao;
import com.subrat.springmvc.model.User;
import com.subrat.springmvc.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public User findById(int id) {
		return userDao.findById(id);
	}

	public User findBySSO(String sso) {
		return userDao.findBySSO(sso);
	}

	public void saveUser(User user) {
		userDao.save(user);		
	}

	public void updateUser(User user) {
		User entity= userDao.findById(user.getId());
		if(entity !=null){
			entity.setEmail("Subrat@world.com");
			entity.setFirstName("Subrat");
			entity.setLastName("Panda");
			entity.setSsoId("007");
			entity.setUserDocuments(user.getUserDocuments());
		}
	}

	public void deleteUserBySSO(String sso) {
		userDao.deleteBySSO(sso);
	}

	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		User user= userDao.findBySSO(sso);
		
		return (user == null || ((id!=null) && (user.getId()== id)));
	}

}
