package me.haitmq.spring.mvc.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.servlet.ModelAndView;

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

		System.out.println("=======>>>>>>user list: " + userList);

		for (User user : userList) {
			System.out.println("=======>>>>>>user item: " + user);
			System.out.println("=======>>>>>>user item: instance of User class: " + (user instanceof User));
		}
		return "user-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create a customer object and add it to model
		theModel.addAttribute("user", new User());

		return "add-user-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult,
			@RequestParam("role") String theRole) {

		if (theBindingResult.hasErrors()) {

			System.out.println("Email fields: |" + theUser.getEmail() + "|");
			System.out.println("phone number fields: |" + theUser.getPhoneNumber() + "|");
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

	@GetMapping("/listByPage")
	public String listByPage(
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(name = "searchingValue",defaultValue = "", required = false) String searchingValue, 
			Model theModel) {
		
		
		Page<User> paginatedData = userService.getPaginatedData(page, size);

		System.out.println("=======>>> pagination data: " + paginatedData);
		System.out.println("=======>>> pagination data (number of elements): " + paginatedData.getNumberOfElements());
		System.out.println("=======>>> pagination data (number): " + paginatedData.getNumber());
		System.out.println("=======>>> pagination data (size): " + paginatedData.getSize());
		System.out.println("=======>>> pagination data (total number): " + paginatedData.getTotalElements());
		System.out.println("=======>>> pagination data (total page): " + paginatedData.getTotalPages());
		System.out.println("=======>>> pagination data (user list): " + paginatedData.getContent());
		for (User user : paginatedData.getContent()) {
			System.out.println("=======>>> pagination data (user item): " + user);
			System.out.println("=======>>>>>>pagination data: instance of User class: " + (user instanceof User));

		}

//	        List<User> users = (List<User>) userService.getPaginatedData(page, size).getContent();

		theModel.addAttribute("searchingValue", searchingValue);

		if (!(searchingValue.equals(""))) {
			paginatedData = userService.findAllByEmailOrPhoneNumber(page, size, searchingValue);
			theModel.addAttribute("searchingValue", searchingValue);
		}

		theModel.addAttribute("paginatedData", paginatedData);
		
		theModel.addAttribute("currentPage", page);

		theModel.addAttribute("currentSize", size);

		int nextPage = page + 1;
		int prevPage = page - 1;

		if (page <= 0) {
			prevPage = 0;
		}

		theModel.addAttribute("prevPage", prevPage);

		if (page >= (paginatedData.getTotalPages() - 1)) {
			nextPage = paginatedData.getTotalPages() - 1;
		}

		theModel.addAttribute("nextPage", nextPage);
		
		
		
		return "page-list";
	}

	@RequestMapping("/testSearching")
	public ModelAndView refesh() {
		ModelAndView mView = new ModelAndView("redirect:/user/listByPage");
		
		return mView;
		
	}
}
