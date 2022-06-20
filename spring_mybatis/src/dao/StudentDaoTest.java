package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import vo.StudentVo;

public class StudentDaoTest {
	
	public static void main(String[] args) {
		try {
			String configPath = "/context/applicationContext.xml";
			ApplicationContext context = new GenericXmlApplicationContext(configPath);
			IStudentDao dao = context.getBean("studentDao", IStudentDao.class);
			for(StudentVo vo : dao.selectStudentList(null)) {
				System.out.println(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
