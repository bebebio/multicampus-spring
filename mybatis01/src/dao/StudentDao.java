package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.StudentVo;

public class StudentDao {
	
	private SqlSessionFactory sessionFactory;
	
	public StudentDao() {
		String configPath = "config/configuration.xml";
		try (Reader reader = Resources.getResourceAsReader(configPath)) {
			// ���� ���� : SqlSessionFactoryBuilder -> SqlSessionFactory -> SqlSession
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertStudent(StudentVo vo) throws Exception {
		// SqlSession�� Thread-safe���� �ʱ� ������ ���� Scope�� ��� �Լ�
		// DAO ������ ���� �ʿ��� Session ��ü������ ��� ������ ������� ����
		// SqlSessionFactory�� ��� ������ �����ϸ鼭 SqlSession�� ȹ���ؾ� �� 
		try (SqlSession session = sessionFactory.openSession()) {
			// XML Mapper ȣ�� : [���ӽ����̽���].[����ID]
			if(session.insert("student.insert", vo) > 0) {
				session.commit();
				return true;
			} else {
				session.rollback();
				return false;
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public boolean updateStudent(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			if(session.insert("student.update", vo) > 0) {
				session.commit();
				return true;
			} else {
				session.rollback();
				return false;
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public boolean deleteStudent(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			if(session.insert("student.delete", vo) > 0) {
				session.commit();
				return true;
			} else {
				session.rollback();
				return false;
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public StudentVo selectStudentBySid(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.selectOne("student.selectBySid", vo);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public List<StudentVo> selectStudent(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.selectList("student.select", vo);
		} catch(Exception e) {
			throw e;
		}
	}
}
