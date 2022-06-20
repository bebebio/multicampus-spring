package dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import constant.Student;

public class StudentDaoTest {
	
	public static void main(String[] args) {
		try {
			String configPath = "/context/applicationContext.xml";
			ApplicationContext context = new GenericXmlApplicationContext(configPath);
			StudentDao dao = context.getBean("studentDao", StudentDao.class);
			
			Map<String, Object> params = new HashMap();
			params.put(Student.SID, 7706);
			params.put(Student.NAME, "ȫ�浿");
			params.put(Student.AGE, 20);
			params.put(Student.SCORE, 100);
			
			System.out.println("- insert : " + dao.insertStudent(params));
			System.out.println("  -> " + dao.selectStudentBySid(params));
			
			params.put(Student.AGE, 21);
			System.out.println("- update : " + dao.updateStudent(params));
			System.out.println("  -> " + dao.selectStudentBySid(params));
			
			System.out.println("- delete : " + dao.deleteStudent(params));
			
			dao.selectStudent(params).forEach(student -> {
				System.out.println(student);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
