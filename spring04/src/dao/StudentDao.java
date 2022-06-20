package dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import constant.Student;
import vo.StudentVo;

@Component
public class StudentDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public boolean insertStudent(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO STUDENT ( SID, NAME, AGE, SCORE ) VALUES ( :sid, :name, :age, :score )");
		
		StudentVo vo = new StudentVo();
		vo.setSid((int) params.get(Student.SID));
		vo.setName((String) params.get(Student.NAME));
		vo.setAge((int) params.get(Student.AGE));
		vo.setScore((int) params.get(Student.SCORE));
		
		// 다건 데이터(스프링 라이브러리 사용)
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(vo);
		
		return jdbcTemplate.update(sql.toString(), paramSource) > 0 ? true : false;
	}
	
	public boolean updateStudent(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE STUDENT SET NAME = :name, AGE = :age, SCORE = :score WHERE SID = :sid");
		
		return jdbcTemplate.update(sql.toString(), params) > 0 ? true : false;
	}
	
	public boolean deleteStudent(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM STUDENT WHERE SID = :sid");
		
		// 단건 데이터(스프링 라이브러리 사용)
		SqlParameterSource paramSource = new MapSqlParameterSource(Student.SID, (int) params.get(Student.SID));
		
		return jdbcTemplate.update(sql.toString(), paramSource) > 0 ? true : false;
	}
	
	public Map<String, Object> selectStudentBySid(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SID AS sid, NAME AS name, AGE AS age, SCORE AS score FROM STUDENT WHERE SID = :sid");
		
		SqlParameterSource paramSource = new MapSqlParameterSource(Student.SID, (int) params.get(Student.SID));
		
		return jdbcTemplate.queryForMap(sql.toString(), paramSource);
	}
	
	public List<Map<String, Object>> selectStudent(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SID AS sid, NAME AS name, AGE AS age, SCORE AS score FROM STUDENT");
		
		return jdbcTemplate.queryForList(sql.toString(), params);
	}
	
}
