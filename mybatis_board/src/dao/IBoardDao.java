package dao;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	
	/** 게시글 등록 */
	public int insertBoard(Map<String, Object> params) throws Exception;
	
	/** 게시글 목록 조회 */
	public List<Map<String, Object>> selectBoardList(Map<String, Object> params) throws Exception;
	
	/** 게시글 전체 건수 조회 */
	public int selectBoardTotalCount() throws Exception;
	
}
