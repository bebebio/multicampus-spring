package dao;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	
	/** �Խñ� ��� */
	public int insertBoard(Map<String, Object> params) throws Exception;
	
	/** �Խñ� ���� */
	public int updateBoard(Map<String, Object> params) throws Exception;
	
	/** �Խñ� ���� */
	public int deleteBoard(Map<String, Object> params) throws Exception;
	
	/** �Խñ� �� ��ȸ */
	public Map<String, Object> selectBoard(Map<String, Object> params) throws Exception;
	
	/** �Խñ� ��� ��ȸ */
	public List<Map<String, Object>> selectBoardList(Map<String, Object> params) throws Exception;
	
	/** �Խñ� �������� ��ȸ */
	public List<Map<String, Object>> selectBoardByTitle(Map<String, Object> params) throws Exception;
	
}
