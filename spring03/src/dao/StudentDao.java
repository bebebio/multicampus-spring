package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import constant.Student;

@Component
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertStudent(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO STUDENT ( SID, NAME, AGE, SCORE ) VALUES ( ?, ?, ?, ? )");
		
		// 파라미터 순서는 알아야 되지만, 타입은 필요 없음
		return jdbcTemplate.update(sql.toString()
				, params.get(Student.SID)
				, params.get(Student.NAME)
				, params.get(Student.AGE)
				, params.get(Student.SCORE)) > 0 ? true : false;
	}
	
	public boolean updateStudent(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE STUDENT SET NAME = ?, AGE = ?, SCORE = ? WHERE SID = ?");
		
		return jdbcTemplate.update(sql.toString()
				, params.get(Student.NAME)
				, params.get(Student.AGE)
				, params.get(Student.SCORE)
				, params.get(Student.SID)) > 0 ? true : false;
	}
	
	public boolean deleteStudent(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM STUDENT WHERE SID = ?");
		
		return jdbcTemplate.update(sql.toString()
				, params.get(Student.SID)) > 0 ? true : false;
	}
	
	public Map<String, Object> selectStudentBySid(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SID AS sid, NAME AS name, AGE AS age, SCORE AS score FROM STUDENT WHERE SID = ?");
		
		//return jdbcTemplate.queryForObject(sql.toString(), new StudentMapper(), params.get(Student.SID));
		return jdbcTemplate.queryForMap(sql.toString(), params.get(Student.SID));
	}
	
	public List<Map<String, Object>> selectStudent(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SID AS sid, NAME AS name, AGE AS age, SCORE AS score FROM STUDENT");
		
		return jdbcTemplate.queryForList(sql.toString());
	}
	
	class StudentMapper implements RowMapper<Map<String, Object>> {
		
		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> resultMap = new HashMap();
			resultMap.put(Student.SID, rs.getInt(Student.SID));
			resultMap.put(Student.NAME, rs.getString(Student.NAME));
			resultMap.put(Student.AGE, rs.getInt(Student.AGE));
			resultMap.put(Student.SCORE, rs.getInt(Student.SCORE));
			return resultMap;
		}
		
	}
}
