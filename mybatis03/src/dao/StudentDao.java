package dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.StudentVo;

public class StudentDao implements IStudentDao {
	
	private SqlSessionFactory sessionFactory;
	
	public StudentDao() {
		String configPath = "config/configuration.xml";
		try (InputStream is = Resources.getResourceAsStream(configPath)) {
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertStudent(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IStudentDao.class).insertStudent(vo);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public int updateStudent(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IStudentDao.class).updateStudent(vo);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public int deleteStudent(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IStudentDao.class).deleteStudent(vo);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public StudentVo selectStudentBySid(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IStudentDao.class).selectStudentBySid(vo);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public List<StudentVo> selectStudent(StudentVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IStudentDao.class).selectStudent(vo);
		} catch(Exception e) {
			throw e;
		}
	}
}
