package dao;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.Emp;

public class EployeeDaoTest {
	
	public static void main(String[] args) {
		
		try {
			// Model 객체를 사용하지 않고 Map으로 대체하기
			// 2개의 테이블에서 데이터 조회하기
			
			EmployeeDao dao = EmployeeDao.getInstance();
			
			Map<String, Object> params = new HashMap();
			params.put(Emp.EMPNO, 7000);
			params.put(Emp.ENAME, "GOH");
			params.put(Emp.JOB, "MANAGER");
			params.put(Emp.MGR, 7001);
			params.put(Emp.HIREDATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			params.put(Emp.SAL, 300.0);
			params.put(Emp.COMM, 10.0);
			params.put(Emp.DEPTNO, 10);
			
			// 직원 정보를 등록하는 기능
			System.out.println("- insertEmp : " + dao.insertEmp(params));
			System.out.println("  -> 등록된 업무 : " + dao.selectEmpByEmpno(params).get(Emp.JOB));
			
			params.put(Emp.JOB, "CLERK");

			// 직원 정보를 수정하는 기능
			System.out.println("- updateEmp : " + dao.updateEmp(params));
			System.out.println("  -> 수정된 업무 : " + dao.selectEmpByEmpno(params).get(Emp.JOB));
			
			// 직원 정보를 삭제하는 기능
			System.out.println("- deleteEmp : " + dao.deleteEmp(params));
			
			// 부서로 직원 정보를 조회하는 기능
			System.out.println("---------- 부서로 직원 정보 조회 ----------");
			dao.selectEmpByDeptno(Collections.singletonMap(Emp.DEPTNO, 10)).forEach(emp -> {
				System.out.println(emp);
			});
			
			// 업무로 직원 정보를 조회하는 기능
			System.out.println("---------- 업무로 직원 정보 조회 ----------");
			dao.selectEmpByJob(Collections.singletonMap(Emp.JOB, "MANAGER")).forEach(emp -> {
				System.out.println(emp); 
			});
			
			// 이름으로 직원 정보를 조회하는 기능
			System.out.println("---------- 이름으로 직원 정보 조회 ----------");
			dao.selectEmpByEname(Collections.singletonMap(Emp.ENAME, "ALL")).forEach(emp -> {
				System.out.println(emp);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
