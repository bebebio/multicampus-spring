package dao;

import java.util.List;

import vo.BoardListVo;
import vo.BoardVo;

public interface IBoardDao {
	
	public int insert(BoardVo boardVo) throws Exception;
	
	public int update(BoardVo boardVo) throws Exception;
	
	public int delete(BoardVo boardVo) throws Exception;
	
	public BoardVo selectOne(BoardVo boardVo) throws Exception;
	
	public List<BoardVo> selectList(BoardVo boardVo) throws Exception;
	
	public int selectTotalCount(BoardVo boardVo) throws Exception;
	
}
