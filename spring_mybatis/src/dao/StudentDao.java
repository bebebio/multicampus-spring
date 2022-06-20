package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.StudentVo;

@Component
public class StudentDao implements IStudentDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertStudent(StudentVo vo) throws Exception {
		//return session.insert("student.insertStudent", vo);
		return session.getMapper(IStudentDao.class).insertStudent(vo);
	}

	@Override
	public int updateStudent(StudentVo vo) throws Exception {
		//return session.update("student.updateStudent", vo);
		return session.getMapper(IStudentDao.class).updateStudent(vo);
	}

	@Override
	public int deleteStudent(StudentVo vo) throws Exception {
		//return session.delete("student.deleteStudent", vo);
		return session.getMapper(IStudentDao.class).deleteStudent(vo);
	}

	@Override
	public StudentVo selectStudentBySid(StudentVo vo) throws Exception {
		//return session.selectOne("student.selectStudentBySid", vo);
		return session.getMapper(IStudentDao.class).selectStudentBySid(vo);
	}

	@Override
	public List<StudentVo> selectStudentList(StudentVo vo) throws Exception {
		//return session.selectList("student.selectStudentList");
		return session.getMapper(IStudentDao.class).selectStudentList(vo);
	}
		
}
