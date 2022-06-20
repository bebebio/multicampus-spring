package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.StudentVo;

@Controller
public class MyController {
	
	// Controller ���� ���
	// �����Ϳ� ������ ������ ��� �ִ� ��� -> ModelAndView
	// �����͸� �ִ� ���
	
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
