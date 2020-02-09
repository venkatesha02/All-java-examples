package com.tyss.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringController {
	
	  @RequestMapping("/hello") 
	  public String hello(ModelMap map) {// handling
	  
	  map.addAttribute("msg", "Hello"); 
	  //return "index";
	  return "index";
	  
	  }
	 
	
//	@RequestMapping("/hello")
//	public ModelAndView hello() {// handling method
//		
//		ModelAndView view = new ModelAndView();
//		view.setViewName("index");
//		view.addObject("msg", "Fuckkkkkk");
//		return view;
//		
//	}

	@GetMapping("/query")
	public String query(@RequestParam(name="name",required = false)String name,@RequestParam(name="age",required = false)Integer age,ModelMap map) {
		map.addAttribute("name", name);
		map.addAttribute("age", age);
		return "query";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/form")
	public String formData(ModelMap map, String name,String email,String password, Long mobnum) {
		map.addAttribute("name", name);
		map.addAttribute("email", email);
		map.addAttribute("pass", password);
		map.addAttribute("phone", mobnum);
		return "formData";
	}
	
	@GetMapping("/path/{name}")
	public String path(ModelMap map, @PathVariable("name")String name1) {
		
		map.addAttribute("name", name1);
		return "path";
	}
	
	@GetMapping("/create-cookie")
	public String createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("name","hate");
		cookie.setMaxAge(606060365);
		response.addCookie(cookie);
		return "create-cookie";
		
	}
	
	@GetMapping("/read-cookie")
	public String readCookie(@CookieValue("name")String name, ModelMap map) {
		map.addAttribute("name", name);
		return "read-cookie";
	}
	
	@GetMapping("/forward")
	public String forward() {
		return "forward:hello";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:http://www.whatsapp.com";
	}
	
	
	
	
	
	
}
