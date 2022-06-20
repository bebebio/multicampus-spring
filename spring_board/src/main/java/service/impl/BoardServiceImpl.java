package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IBoardDao;
import service.IBoardService;
import vo.BoardListVo;
import vo.BoardVo;

@Service
public class BoardServiceImpl implements IBoardService {
	
	@Autowired
	private IBoardDao boardDao;
	
	@Override
	public boolean insertBoard(BoardVo boardVo) throws Exception {
		return boardDao.insert(boardVo) > 0 ? true : false;
	}

	@Override
	public boolean updateBoard(BoardVo boardVo) throws Exception {
		return boardDao.update(boardVo) > 0 ? true : false;
	}

	@Override
	public boolean deleteBoard(BoardVo boardVo) throws Exception {
		return boardDao.delete(boardVo) > 0 ? true : false;
	}

	@Override
	public BoardVo selectBoard(BoardVo boardVo) throws Exception {
		return boardDao.selectOne(boardVo);
	}

	@Override
	public BoardListVo selectBoardList(BoardVo boardVo) throws Exception {
		List<BoardVo> productList = boardDao.selectList(boardVo);
		int pageTotalCount = boardDao.selectTotalCount(boardVo);
		
		int pageIndex = boardVo.getPageIndex();
		int pageSize = boardVo.getPageSize();
		
		// 페이지 처리
		int pageFirst = 1;
		int pageBegin = (pageIndex - 1) / pageSize * pageSize  + 1;
		int pageEnd = ((pageIndex - 1) / pageSize + 1) * pageSize;
		int pageLast = (boardDao.selectTotalCount(boardVo) - 1) / pageSize + 1;
		pageEnd = pageEnd > pageLast ? pageLast : pageEnd;
		
		BoardListVo boardListVo = new BoardListVo();
		boardListVo.setPageIndex(pageIndex);
		boardListVo.setPageFirst(pageFirst);
		boardListVo.setPageBegin(pageBegin);
		boardListVo.setPageEnd(pageEnd);
		boardListVo.setPageLast(pageLast);
		boardListVo.setPageTotalCount(pageTotalCount);
		boardListVo.setBoardList(productList);
		
		return boardListVo;
	}

}
