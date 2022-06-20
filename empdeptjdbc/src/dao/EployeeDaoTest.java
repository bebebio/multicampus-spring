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
			// Model ��ü�� ������� �ʰ� Map���� ��ü�ϱ�
			// 2���� ���̺��� ������ ��ȸ�ϱ�
			
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
			
			// ���� ������ ����ϴ� ���
			System.out.println("- insertEmp : " + dao.insertEmp(params));
			System.out.println("  -> ��ϵ� ���� : " + dao.selectEmpByEmpno(params).get(Emp.JOB));
			
			params.put(Emp.JOB, "CLERK");

			// ���� ������ �����ϴ� ���
			System.out.println("- updateEmp : " + dao.updateEmp(params));
			System.out.println("  -> ������ ���� : " + dao.selectEmpByEmpno(params).get(Emp.JOB));
			
			// ���� ������ �����ϴ� ���
			System.out.println("- deleteEmp : " + dao.deleteEmp(params));
			
			// �μ��� ���� ������ ��ȸ�ϴ� ���
			System.out.println("---------- �μ��� ���� ���� ��ȸ ----------");
			dao.selectEmpByDeptno(Collections.singletonMap(Emp.DEPTNO, 10)).forEach(emp -> {
				System.out.println(emp);
			});
			
			// ������ ���� ������ ��ȸ�ϴ� ���
			System.out.println("---------- ������ ���� ���� ��ȸ ----------");
			dao.selectEmpByJob(Collections.singletonMap(Emp.JOB, "MANAGER")).forEach(emp -> {
				System.out.println(emp); 
			});
			
			// �̸����� ���� ������ ��ȸ�ϴ� ���
			System.out.println("---------- �̸����� ���� ���� ��ȸ ----------");
			dao.selectEmpByEname(Collections.singletonMap(Emp.ENAME, "ALL")).forEach(emp -> {
				System.out.println(emp);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
