package wrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public abstract class PreparedStatementWrapper implements AutoCloseable {
	
	protected PreparedStatement statement;
	
	public PreparedStatementWrapper(Connection conn, String sql, Map<String, Object> params) throws SQLException {
		statement = conn.prepareStatement(sql);
		prepareStatement(params);
	}
	
	protected abstract void prepareStatement(Map<String, Object> params) throws SQLException;
	
	public ResultSet executeQuery() throws SQLException {
		return statement.executeQuery();
	}
	
	public int executeUpdate() throws SQLException {
		return statement.executeUpdate();
	}

	@Override
	public void close() throws Exception {
		try {
			if(statement != null) {
				statement.close();				
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
}
