package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TilesController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello.tiles");
		return mav;
	}
	
	@RequestMapping("/bye.do")
	public ModelAndView bye() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bye.tiles");
		return mav;
	}
	
}
