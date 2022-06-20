package dao;

import java.util.List;

import vo.BoardVo;

public interface IBoardDao {
	
	public int insert(BoardVo vo) throws Exception;
	
	public int update(BoardVo vo) throws Exception;
	
	public int delete(BoardVo vo) throws Exception;
	
	public BoardVo selectOne(BoardVo vo) throws Exception;
	
	public List<BoardVo> selectList(BoardVo vo) throws Exception;
	
	public int selectTotalCount(BoardVo vo) throws Exception;
	
}
