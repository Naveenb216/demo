package com.bnr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnr.model.Employee;
import com.bnr.model.User;
import com.bnr.model.UserTo;
import com.bnr.repository.UserRepository;

@RestController
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	private UserRepository userDao;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "test";
	}

	@RequestMapping("/getAllEmp")
	public List<Employee> getAllEmployees() {
		List<Employee> li = new ArrayList<>();
		Employee emp = new Employee();
		emp.setEmpId(40185942);
		emp.setEmpname("NAVEEN");
		emp.setEmpSal(45000);

		Employee emp1 = new Employee();
		emp1.setEmpId(40185942);
		emp1.setEmpname("NAVEEN");
		emp1.setEmpSal(45000);
System.out.println("testing>..");
System.out.println("br2");
System.out.println("upd");
System.out.println("space.");





		li.add(emp);
		li.add(emp1);
		return li;
	}

	
	/*
	 * create?email=[email]&name=[name]
	 */
	@RequestMapping("/create")
	public User create(String email, String name) {
		String userId = "";
		User user = null;
		try {
			user = new User(email, name);
			userDao.save(user);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			// return "Error creating the user: " + ex);
		}
		return user;
	}

	/*
	 * /update?id=[id]&email=[email]&name=[name]
	 */
	@RequestMapping("/update")
	public String updateUser(long id, String email, String name) {
		try {
			User user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}
	
	
	/*
	 * /delete?id=[id]:
	 */
	@RequestMapping("/delete")
	  public String delete(long id) {
	    try {
	      User user = new User(id);
	      userDao.delete(user);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	
	
	/*
	 * 
	 * /getByEmail?email=[email]
	 */
	@RequestMapping("/getByEmail")
//	  public   List<User> getByEmail(@PathVariable("email") String email) {
	public   List<User> getByEmail(@RequestBody UserTo usr) {
		List<User> user  = null;
		HttpSession h = request.getSession();
	    if(usr.getEmail().equals(h.getAttribute("email"))){
	    	System.out.println("same user requesting...>>>>>>>");
	    	user = (List<User>) h.getAttribute("data");
	    }else{
	    	System.out.println("Different request....>>>>>>>>");
	    	user= userDao.findByEmail(usr.getEmail());
	    	if(!user.isEmpty()){
	    		h.setAttribute("email",user.get(0).getEmail());
		    	h.setAttribute("data",user);

	    	}
	    	
	    }
		return user;
	  }
	
	@RequestMapping("/getUser")
	public UserTo getUserById(@RequestBody UserTo usr){
		UserTo user = null;
		User us = null;
		HttpSession h = request.getSession();
	    if(usr.getId()== h.getAttribute("id")){
	    	System.out.println("same user requesting...>>>>>>>");
	    	user = (UserTo) h.getAttribute("data");
	    }else{
	    	System.out.println("Different request....>>>>>>>>");
	    	us= userDao.findOne(usr.getId());
	    	if(!StringUtils.isEmpty(us)){
	    		user = new UserTo();
	    		BeanUtils.copyProperties(us, user);
	    		h.setAttribute("id",us.getId());
		    	h.setAttribute("data",user);

	    	}
	    	
	    }
		return user;

	}
}
