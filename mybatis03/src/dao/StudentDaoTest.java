package dao;

import vo.StudentVo;

public class StudentDaoTest {
	
	public static void main(String[] args) {
		try {
			IStudentDao dao = new StudentDao();
			
			StudentVo vo = new StudentVo();
			vo.setSid(8500);
			vo.setName("ȫ�浿");
			vo.setAge(20);
			vo.setScore(100);
			
			System.out.println("- insert : " + dao.insertStudent(vo));
			System.out.println("  -> " + dao.selectStudentBySid(vo));
			
			vo.setAge(21);
			System.out.println("- update : " + dao.updateStudent(vo));
			System.out.println("  -> " + dao.selectStudentBySid(vo));
			
			System.out.println("- delete : " + dao.deleteStudent(vo));
			
			dao.selectStudent(vo).forEach(student -> {
				System.out.println(student);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
