package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.StudentVo;

@Controller
public class MyController {
	
	// Controller 리턴 방식
	// 데이터와 페이지 정보가 모두 있는 경우 -> ModelAndView
	// 데이터만 있는 경우
	
	@RequestMapping("onlyData1.do")
	public Map<String, Object> onlyData1() {
		Map<String, Object> map = new HashMap();
		map.putIfAbsent("greeting", "hello");
		return map;	
	}
	
	@RequestMapping("onlyData2.do")
	public StudentVo onlyData2() {
		StudentVo vo = new StudentVo();
		vo.setSid(1);
		return vo;
	}
	
	@RequestMapping("onlyPage1.do")
	public String onlyPage1(Model model) {
		model.addAttribute("greeting", "hello");
		return "onlyPage1";
	}
	
	@RequestMapping("onlyPage2.do")
	public void onlyPage2(Model model) {
		model.addAttribute("greeting", "hello");
	}
	
}
