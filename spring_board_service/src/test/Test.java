package test;

import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import service.IMemberService;
import vo.MemberListVo;
import vo.MemberVo;

public class Test {

	public static void main(String[] args) {
		String configPath = "/context/applicationContext.xml";
		ApplicationContext context = new GenericXmlApplicationContext(configPath);
		IMemberService service = context.getBean("memberServiceImpl", IMemberService.class);
		
		try {
			MemberVo memberVo = new MemberVo();
			memberVo.setId("user" + UUID.randomUUID().toString().substring(0, 16));
			memberVo.setPw("pass" + UUID.randomUUID().toString().substring(0, 16));
			
			service.insertMember(memberVo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
