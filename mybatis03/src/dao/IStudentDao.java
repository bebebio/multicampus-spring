package dao;

import java.util.List;

import vo.StudentVo;

public interface IStudentDao {
	
	public int insertStudent(StudentVo vo) throws Exception;
	
	public int updateStudent(StudentVo vo) throws Exception;
	
	public int deleteStudent(StudentVo vo) throws Exception;
	
	public StudentVo selectStudentBySid(StudentVo vo) throws Exception;
	
	public List<StudentVo> selectStudent(StudentVo vo) throws Exception;
	
}
