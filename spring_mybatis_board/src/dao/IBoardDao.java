package dao;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	
	public int insertBoard(Map<String, Object> params) throws Exception;
	
	public int updateBoard(Map<String, Object> params) throws Exception;
	
	public int deleteBoard(Map<String, Object> params) throws Exception;
	
	public Map<String, Object> selectOne(Map<String, Object> params) throws Exception;
	
	public List<Map<String, Object>> selectList(Map<String, Object> params) throws Exception;
	
	public int selectTotalCount() throws Exception;
	
}
