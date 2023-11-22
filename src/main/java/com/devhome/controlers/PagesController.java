package com.devhome.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class PagesController {

	@Controller
	public class PageController {
		
//		@RequestMapping("/home")
//		@ResponseBody
//		public ModelAndView home(){
//			ModelAndView modelAndView = new ModelAndView();
//			modelAndView.setViewName("index.html");
//			return modelAndView;		
//		}
//		@RequestMapping("/curso")
//		@ResponseBody
//		public ModelAndView curso(){
//			ModelAndView modelAndView = new ModelAndView();
//			modelAndView.setViewName("html/course.html");
//			return modelAndView;		
//		}

		@RequestMapping("/home")
		public String home(){
			return "index";
		}
		
		@RequestMapping("/inspire")
		public String inspire(){
			return "inspired";
		}
		
		@RequestMapping("/curso")
		public String curso(){
			return "course";
		}
		
////		@RequestMapping("/cadastro")
////		public String cadastro(){
////			return "cadastro";
//		}
		@GetMapping("/login")
		public String login(){
			return "login";
		}
		
	}

}