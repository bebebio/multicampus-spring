package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello(HttpServletRequest request, HttpServletResponse response
			, @RequestParam(required = false, value = "name") String yourName
			, @RequestParam(defaultValue = "0") int age) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("greeting", "hello");
		mav.addObject("yourIP", request.getRemoteAddr());
		mav.addObject("yourName", yourName);
		mav.addObject("yourAge", age);
		mav.setViewName("hello");
		return mav;
	}
	
	@RequestMapping("goToNaver.do")
	public ModelAndView goToNaver() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:https://www.naver.com");
		return mav;
	}
}
