package dao;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	
	/** 게시글 등록 */
	public int insertBoard(Map<String, Object> params) throws Exception;
	
	/** 게시글 수정 */
	public int updateBoard(Map<String, Object> params) throws Exception;
	
	/** 게시글 삭제 */
	public int deleteBoard(Map<String, Object> params) throws Exception;
	
	/** 게시글 상세 조회 */
	public Map<String, Object> selectBoard(Map<String, Object> params) throws Exception;
	
	/** 게시글 목록 조회 */
	public List<Map<String, Object>> selectBoardList(Map<String, Object> params) throws Exception;
	
	/** 게시글 제목으로 조회 */
	public List<Map<String, Object>> selectBoardByTitle(Map<String, Object> params) throws Exception;
	
}
