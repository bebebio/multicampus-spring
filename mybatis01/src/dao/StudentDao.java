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
			// 생성 순서 : SqlSessionFactoryBuilder -> SqlSessionFactory -> SqlSession
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertStudent(StudentVo vo) throws Exception {
		// SqlSession은 Thread-safe하지 않기 때문에 권장 Scope는 멤버 함수
		// DAO 구현을 위해 필요한 Session 객체이지만 멤버 변수로 사용하지 않음
		// SqlSessionFactory를 멤버 변수로 유지하면서 SqlSession을 획득해야 됨 
		try (SqlSession session = sessionFactory.openSession()) {
			// XML Mapper 호출 : [네임스페이스명].[구문ID]
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
