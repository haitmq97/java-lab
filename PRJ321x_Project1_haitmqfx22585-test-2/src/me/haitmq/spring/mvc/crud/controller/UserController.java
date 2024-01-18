package me.haitmq.spring.mvc.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.haitmq.spring.mvc.crud.entity.Role;
import me.haitmq.spring.mvc.crud.entity.User;
import me.haitmq.spring.mvc.crud.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String list(Model theModel) {
		// get customer list from DAO
		List<User> userList = userService.getUserList();

		// add customer to the model
		theModel.addAttribute("users", userList);
		return "user-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create a customer object and add it to model
		theModel.addAttribute("user", new User());
		
		return "add-user-form";
	}
	
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult,  @RequestParam("role") String theRole) {
	
		
		if(theBindingResult.hasErrors()) {
			
			System.out.println("Email fields: |" + theUser.getEmail()+"|");
			System.out.println("phone number fields: |" + theUser.getPhoneNumber()+"|");
			System.out.println("||");
			System.out.println("length: " + "".length());
			for (ObjectError error : theBindingResult.getAllErrors()) {
	            System.out.println(error.getDefaultMessage());
	        }
			return "add-user-form";
		} else {
			Role role = new Role(theRole);
			
			theUser.setRole(role);
			theUser.setStatus(1);
			// save customer
			userService.save(theUser);
			return "redirect:/user/list";
		}
		
			
	}
	
	@RequestMapping("/views/page/{pageid}")
	public String listByPage(@PathVariable int pageid, Model theModel, @RequestParam(name = "entries", defaultValue = "20") String entries) {
		try {
			int total = Integer.parseInt(entries);
			if(pageid ==1d ) {
				
			} else {
				pageid = (pageid-1)*total+1;
			}
			
			System.out.println("pageid: " + pageid);
			List<User> list = userService.getUsersByPage(pageid, total);
			
			theModel.addAttribute("msg", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "view-page";
	}
	
	
	


}
