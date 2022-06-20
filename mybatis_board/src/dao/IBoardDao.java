package dao;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	
	/** �Խñ� ��� */
	public int insertBoard(Map<String, Object> params) throws Exception;
	
	/** �Խñ� ��� ��ȸ */
	public List<Map<String, Object>> selectBoardList(Map<String, Object> params) throws Exception;
	
	/** �Խñ� ��ü �Ǽ� ��ȸ */
	public int selectBoardTotalCount() throws Exception;
	
}
