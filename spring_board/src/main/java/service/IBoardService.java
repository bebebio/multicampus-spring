package service;

import vo.BoardListVo;
import vo.BoardVo;

public interface IBoardService {
	
	public boolean insertBoard(BoardVo boardVo) throws Exception;
	
	public boolean updateBoard(BoardVo boardVo) throws Exception;
	
	public boolean deleteBoard(BoardVo boardVo) throws Exception;
	
	public BoardVo selectBoard(BoardVo boardVo) throws Exception;
	
	public BoardListVo selectBoardList(BoardVo boardVo) throws Exception;
	
}
