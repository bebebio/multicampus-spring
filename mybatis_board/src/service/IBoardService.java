package service;

import java.util.List;
import java.util.Map;

public interface IBoardService {
	
	/** 게시글 등록 */
	public boolean insertBoard(String pass, String name, String email, String title, String content) throws Exception;
//	
//	/** 게시글 수정 */
//	public boolean updateBoard(int num, String pass, String name, String email, String title, String content) throws Exception;
//	
//	/** 게시글 삭제 */
//	public boolean deleteBoard(int num) throws Exception;
//	
//	/** 게시글 상세 조회 */
//	public Map<String, Object> selectBoard(int num) throws Exception;
//	
	/** 게시글 목록 조회 */
	public Map<String, Object> selectBoardList(int pageIndex, int pageSize) throws Exception;
	
//	/** 제목으로 게시글 목록 조회 */
//	public List<Map<String, Object>> selectBoardByTitle(List<String> titles) throws Exception;
//	
}
