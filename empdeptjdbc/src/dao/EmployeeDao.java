package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.Emp;
import wrapper.PreparedStatementWrapper;

public class EmployeeDao {
	
	// 직원 정보를 등록하는 기능
	// 직원 정보를 수정하는 기능
	// 직원 정보를 삭제하는 기능
	// 부서로 직원 정보를 검색하는 기능
	// 업무로 직원 정보를 검색하는 기능
	// 이름(포함)으로 직원 정보를 검색하는 기능
	
	private static EmployeeDao instance;
	
	private EmployeeDao() {}
	
	public static EmployeeDao getInstance() {
		if(instance == null) {
			instance = new EmployeeDao();
		}
		return instance;
	}
	
	public Connection getConnetion() throws Exception {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mariadb://localhost:3307/multicampus", "multicampus", "multicampus");
		} catch (Exception e) {
			throw e;
		}
	}
	
	/** 직원 정보 등록 */
	public boolean insertEmp(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO ) ");
		sql.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ? ) ");
		
		try (
			Connection conn = getConnetion();	
			PreparedStatementWrapper wrapper = new PreparedStatementWrapper(conn, sql.toString(), params) {	
				@Override
				protected void prepareStatement(Map<String, Object> params) throws SQLException {
					statement.setInt   (1, (int)    params.get(Emp.EMPNO)   );
					statement.setString(2, (String) params.get(Emp.ENAME)   );
					statement.setString(3, (String) params.get(Emp.JOB)     );
					statement.setInt   (4, (int)    params.get(Emp.MGR)     );
					statement.setString(5, (String) params.get(Emp.HIREDATE));
					statement.setDouble(6, (double) params.get(Emp.SAL)     );
					statement.setDouble(7, (double) params.get(Emp.COMM)    );
					statement.setInt   (8, (int)    params.get(Emp.DEPTNO)  );
				}
			};
		) {	
			int result = wrapper.executeUpdate();
			
			if(result > 0) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 직원 정보 수정 */
	public boolean updateEmp(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE EMP SET ");
		sql.append("ENAME = ?, JOB = ?, MGR = ?, HIREDATE = ?, SAL = ?, COMM = ?, DEPTNO = ? ");
		sql.append("WHERE EMPNO = ? ");
		
		try (
			Connection conn = getConnetion();
			PreparedStatementWrapper wrapper = new PreparedStatementWrapper(conn, sql.toString(), params) {	
				@Override
				protected void prepareStatement(Map<String, Object> params) throws SQLException {
					statement.setString(1, (String) params.get(Emp.ENAME)   );
					statement.setString(2, (String) params.get(Emp.JOB)     );
					statement.setInt   (3, (int)    params.get(Emp.MGR)     );
					statement.setString(4, (String) params.get(Emp.HIREDATE));
					statement.setDouble(5, (double) params.get(Emp.SAL)     );
					statement.setDouble(6, (double) params.get(Emp.COMM)    );
					statement.setInt   (7, (int)    params.get(Emp.DEPTNO)  );
					statement.setInt   (8, (int)    params.get(Emp.EMPNO)   );
				}
			};
		) {
			int result = wrapper.executeUpdate();
			
			if(result > 0) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 직원 정보 삭제 */
	public boolean deleteEmp(Map<String, Object> params) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM EMP WHERE EMPNO = ?");
		
		try (
			Connection conn = getConnetion();
			PreparedStatementWrapper wrapper = new PreparedStatementWrapper(conn, sql.toString(), params) {
				@Override
				protected void prepareStatement(Map<String, Object> params) throws SQLException {
					statement.setInt(1, (int) params.get(Emp.EMPNO));
				}
			};
		) {
			int result = wrapper.executeUpdate();
			
			if(result > 0) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 번호로 직원 정보 조회 */
	public Map<String, Object> selectEmpByEmpno(Map<String, Object> params) throws Exception {
		Map<String, Object> resultMap = new HashMap();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.EMPNO = ? ");
		
		try (
			Connection conn = getConnetion();
			PreparedStatementWrapper wrapper = new PreparedStatementWrapper(conn, sql.toString(), params) {	
				@Override
				protected void prepareStatement(Map<String, Object> params) throws SQLException {
					statement.setInt(1, (int) params.get(Emp.EMPNO));
				}
			};
			ResultSet rs = wrapper.executeQuery();
		) {
			if(rs.next()) {				
				resultMap.put(Emp.EMPNO   , rs.getInt(Emp.EMPNO)      );
				resultMap.put(Emp.ENAME   , rs.getString(Emp.ENAME)   );
				resultMap.put(Emp.JOB     , rs.getString(Emp.JOB)     );
				resultMap.put(Emp.MGR     , rs.getString(Emp.MGR)     );
				resultMap.put(Emp.HIREDATE, rs.getString(Emp.HIREDATE));
				resultMap.put(Emp.SAL     , rs.getDouble(Emp.SAL)     );
				resultMap.put(Emp.COMM    , rs.getDouble(Emp.COMM)    );
				resultMap.put(Emp.DEPTNO  , rs.getInt(Emp.DEPTNO)     );
			}
			
			return resultMap;
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 부서로 직원 정보 조회 */
	public List<Map<String, Object>> selectEmpByDeptno(Map<String, Object> params) throws Exception {
		List<Map<String, Object>> resultList = new ArrayList();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = ? ");
		
		try (
			Connection conn = getConnetion();
			PreparedStatementWrapper wrapper = new PreparedStatementWrapper(conn, sql.toString(), params) {	
				@Override
				protected void prepareStatement(Map<String, Object> params) throws SQLException {
					statement.setInt(1, (int) params.get(Emp.DEPTNO));
				}
			};
			ResultSet rs = wrapper.executeQuery();
		) {
			while(rs.next()) {
				Map<String, Object> resultMap = new HashMap();
				resultMap.put(Emp.EMPNO   , rs.getInt(Emp.EMPNO)      );
				resultMap.put(Emp.ENAME   , rs.getString(Emp.ENAME)   );
				resultMap.put(Emp.JOB     , rs.getString(Emp.JOB)     );
				resultMap.put(Emp.MGR     , rs.getString(Emp.MGR)     );
				resultMap.put(Emp.HIREDATE, rs.getString(Emp.HIREDATE));
				resultMap.put(Emp.SAL     , rs.getDouble(Emp.SAL)     );
				resultMap.put(Emp.COMM    , rs.getDouble(Emp.COMM)    );
				resultMap.put(Emp.DEPTNO  , rs.getInt(Emp.DEPTNO)     );
				resultList.add(resultMap);
			}
			
			return resultList;
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 업무로 직원 정보 조회 */
	public List<Map<String, Object>> selectEmpByJob(Map<String, Object> params) throws Exception {
		List<Map<String, Object>> resultList = new ArrayList();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.JOB = ? ");
		
		try (
			Connection conn = getConnetion();
			PreparedStatementWrapper wrapper = new PreparedStatementWrapper(conn, sql.toString(), params) {	
				@Override
				protected void prepareStatement(Map<String, Object> params) throws SQLException {
					statement.setString(1, (String) params.get(Emp.JOB));
				}
			};
			ResultSet rs = wrapper.executeQuery();
		) {
			while(rs.next()) {
				Map<String, Object> resultMap = new HashMap();
				resultMap.put(Emp.EMPNO   , rs.getInt(Emp.EMPNO)      );
				resultMap.put(Emp.ENAME   , rs.getString(Emp.ENAME)   );
				resultMap.put(Emp.JOB     , rs.getString(Emp.JOB)     );
				resultMap.put(Emp.MGR     , rs.getString(Emp.MGR)     );
				resultMap.put(Emp.HIREDATE, rs.getString(Emp.HIREDATE));
				resultMap.put(Emp.SAL     , rs.getDouble(Emp.SAL)     );
				resultMap.put(Emp.COMM    , rs.getDouble(Emp.COMM)    );
				resultMap.put(Emp.DEPTNO  , rs.getInt(Emp.DEPTNO)     );
				resultList.add(resultMap);
			}
			
			return resultList;
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 이름으로 직원 정보 조회 */
	public List<Map<String, Object>> selectEmpByEname(Map<String, Object> params) throws Exception {
		List<Map<String, Object>> resultList = new ArrayList();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM EMP E, DEPT D ");
		sql.append("WHERE E.DEPTNO = D.DEPTNO AND E.ENAME LIKE CONCAT('%', ?, '%') ");
		
		try (
			Connection conn = getConnetion();
			PreparedStatementWrapper wrapper = new PreparedStatementWrapper(conn, sql.toString(), params) {	
				@Override
				protected void prepareStatement(Map<String, Object> params) throws SQLException {
					statement.setString(1, (String) params.get(Emp.ENAME));
				}
			};
			ResultSet rs = wrapper.executeQuery();
		) {
			while(rs.next()) {
				Map<String, Object> resultMap = new HashMap();
				resultMap.put(Emp.EMPNO   , rs.getInt(Emp.EMPNO)      );
				resultMap.put(Emp.ENAME   , rs.getString(Emp.ENAME)   );
				resultMap.put(Emp.JOB     , rs.getString(Emp.JOB)     );
				resultMap.put(Emp.MGR     , rs.getString(Emp.MGR)     );
				resultMap.put(Emp.HIREDATE, rs.getString(Emp.HIREDATE));
				resultMap.put(Emp.SAL     , rs.getDouble(Emp.SAL)     );
				resultMap.put(Emp.COMM    , rs.getDouble(Emp.COMM)    );
				resultMap.put(Emp.DEPTNO  , rs.getInt(Emp.DEPTNO)     );
				resultList.add(resultMap);
			}
			
			return resultList;
		} catch(Exception e) {
			throw e;
		}
	}
	
}
