package com.subrat.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.subrat.springmvc.model.FileBucket;
import com.subrat.springmvc.model.User;
import com.subrat.springmvc.model.UserDocument;
import com.subrat.springmvc.service.UserDocumentService;
import com.subrat.springmvc.service.UserService;


@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDocumentService userDcoument;
	
	@Autowired
	MessageSource messageSource;

	
	
	
	  /**
     * This method will list all existing users.
     */
	
	@RequestMapping(value= {"/", "/list" }, method= RequestMethod.GET)
	public String listUsers(ModelMap map){
		List<User> users= userService.findAllUsers();
		map.addAttribute("abc",users);
		return "userslist";
	}
	

    /**
     * This method will provide the medium to add a new user.
     */
	
	@RequestMapping(value= {"/newuser"}, method=RequestMethod.GET)
	public String newUser(ModelMap model){
		User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
	}
	
	@RequestMapping(value= {"/newuser"}, method=RequestMethod.POST)
	public String saveUser(User user, ModelMap model,BindingResult result){
		if (result.hasErrors()){
			return "registration"; 
		}
		
		userService.saveUser(user);
		 model.addAttribute("user", user);
	     model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
	     return "registrationsuccess";
	}
	
	@RequestMapping(value ="/edit-user-{ssoId}", method= RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model){
		User user= userService.findBySSO(ssoId);
		model.addAttribute("user",user);
		model.addAttribute("edit",true);
		return "registration";
		
		}
	@RequestMapping(value ="/edit-user-{ssoId}", method= RequestMethod.POST)
	public String updateUser(User user,ModelMap model,@PathVariable String ssoId){
		userService.updateUser(user);
		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		return "registrationsuccess";
	}
	
	  @RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.DELETE)
	    public String deleteUser(@PathVariable String ssoId) {
	        userService.deleteUserBySSO(ssoId);
	        return "redirect:/list";
	    }
	  
	  
	 @RequestMapping(value= "/add-document-{userId}", method= RequestMethod.GET)
	 public String addDocument(@PathVariable int userId, ModelMap model){
		 
		 System.out.println("UserId is:- "+ userId);
		 User user= userService.findById(userId);
		 model.addAttribute("user",user);
		 
		 FileBucket file= new FileBucket();
		 model.addAttribute("fileBucket",file);
		 
		 List<UserDocument> documents= userDcoument.findAllByUserId(userId);
		 model.addAttribute("documents",documents);
		 return "managedocuments";
	 }
	 
	 
	 @RequestMapping(value= "/add-document-{userId}", method= RequestMethod.POST)
	 public String uploadDocument(FileBucket bucket, ModelMap model, @PathVariable int userId) throws IOException{
		 
		 System.out.println("Fetching file");
		 User user= userService.findById(userId);
		 model.addAttribute("user",user);
		 saveDocuments(bucket,user);
		 return "redirect:/add-document-"+userId;
		 
		 }
	 private void saveDocuments(FileBucket bucket, User user) throws IOException{
		 
		 UserDocument document= new UserDocument();
		 MultipartFile multipartFile= bucket.getFile();
		 document.setContent(multipartFile.getBytes());
		 document.setDescription(bucket.getDescription());
		 document.setName(multipartFile.getName());
		 document.setType(multipartFile.getContentType());
		 document.setUser(user);
		 userDcoument.saveDocument(document);
	 }
	 
	 @RequestMapping(value="/download-document-{userId}-{docId}", method=RequestMethod.GET)
	 public void downloadDocument(@PathVariable int userId, @PathVariable int docId, HttpServletResponse response) throws IOException{
		 UserDocument document= userDcoument.findById(docId);
		 response.setContentLength(document.getContent().length);
		 response.setContentType(document.getType());
		 System.out.println("ContentType= "+document.getType());
		// response.setHeader("Content-Disposition", "attachment; filename=\""+document.getName()+"\"");
		 response.setHeader("Content-Disposition", "attachment; filename=\"" + document.getName() +"\"");
		 FileCopyUtils.copy(document.getContent(),response.getOutputStream());
		 response.getOutputStream().close();
		// return "redirect:/add-document-"+userId;
	 }
	
}
