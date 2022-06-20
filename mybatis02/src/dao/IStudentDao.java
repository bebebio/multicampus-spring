package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import vo.StudentVo;

public interface IStudentDao {
	
	@Insert("INSERT INTO STUDENT (SID, NAME, AGE, SCORE) VALUES ( ${sid}, #{name}, ${age}, ${score} )")
	public int insertStudent(StudentVo vo) throws Exception;
	
	@Update("UPDATE STUDENT SET NAME = #{name}, AGE = ${age}, SCORE = ${score} WHERE SID = ${sid}")
	public int updateStudent(StudentVo vo) throws Exception;
	
	@Delete("DELETE FROM STUDENT WHERE SID = ${sid}")
	public int deleteStudent(StudentVo vo) throws Exception;
	
	@Select("SELECT SID AS sid, NAME AS name, AGE AS age, SCORE AS score FROM STUDENT WHERE SID = ${sid}")
	public StudentVo selectStudentBySid(StudentVo vo) throws Exception;
	
	@Select("SELECT SID AS sid, NAME AS name, AGE AS age, SCORE AS score FROM STUDENT")
	public List<StudentVo> selectStudent(StudentVo vo) throws Exception;
	
}
