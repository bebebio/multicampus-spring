package service;

import java.util.List;
import java.util.Map;

public interface IBoardService {
	
	public boolean insertBoard(Map<String, Object> params) throws Exception;
	
	public boolean updateBoard(Map<String, Object> params) throws Exception;
	
	public boolean deleteBoard(Map<String, Object> params) throws Exception;
	
	public Map<String, Object> selectBoard(Map<String, Object> params) throws Exception;
	
	public Map<String, Object> selectBoardList(Map<String, Object> params) throws Exception;
	
}
