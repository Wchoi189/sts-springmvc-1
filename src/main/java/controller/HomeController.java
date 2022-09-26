package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView homeController(ModelAndView mav) {
		System.out.println("homeController");
		mav.setViewName("index");
		return mav;
	}
	@GetMapping("/index")
	public String homeController2() {
		System.out.println("homeController");
		return "index";
	}
}
