package service;

import java.util.List;
import java.util.Map;

public interface IBoardService {
	
	/** �Խñ� ��� */
	public boolean insertBoard(String pass, String name, String email, String title, String content) throws Exception;
//	
//	/** �Խñ� ���� */
//	public boolean updateBoard(int num, String pass, String name, String email, String title, String content) throws Exception;
//	
//	/** �Խñ� ���� */
//	public boolean deleteBoard(int num) throws Exception;
//	
//	/** �Խñ� �� ��ȸ */
//	public Map<String, Object> selectBoard(int num) throws Exception;
//	
	/** �Խñ� ��� ��ȸ */
	public Map<String, Object> selectBoardList(int pageIndex, int pageSize) throws Exception;
	
//	/** �������� �Խñ� ��� ��ȸ */
//	public List<Map<String, Object>> selectBoardByTitle(List<String> titles) throws Exception;
//	
}
