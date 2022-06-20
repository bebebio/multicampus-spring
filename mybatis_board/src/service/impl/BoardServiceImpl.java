package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.Board;
import dao.BoardDao;
import dao.IBoardDao;
import service.IBoardService;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao dao = new BoardDao();

	@Override
	public boolean insertBoard(String pass, String name, String email, String title, String content) throws Exception {
		Map<String, Object> params = new HashMap();
		params.put(Board.PASS, pass);
		params.put(Board.NAME, name);
		params.put(Board.EMAIL, email);
		params.put(Board.TITLE, title);
		params.put(Board.CONTENT, content);
		
		return dao.insertBoard(params) > 0 ? true : false;
	}
	
	@Override
	public Map<String, Object> selectBoardList(int pageIndex, int pageSize) throws Exception {
		// 첫 페이지(맨 앞 페이지)
		int pageFirst = 1;
		// 시작 페이지(현재 보이는 시작 페이지)
		int pageBegin = (pageIndex - 1) / pageSize * pageSize + 1;
		// 종료 페이지(현재 보이는 종료 페이지)
		int pageEnd = ((pageIndex - 1) / 10 + 1) * pageSize;
		// 끝 페이지(맨 뒤 페이지)
		int pageLast = (dao.selectBoardTotalCount() - 1) / pageSize + 1;
		// 종료 페이지 검증
		pageEnd = pageEnd > pageLast ? pageLast : pageEnd;
		
		Map<String, Object> params = new HashMap();
		int pageSkip = (pageIndex - 1) * pageSize;
		params.put("paegSkip", pageSkip);
		params.put("pageSize", pageSize);
		
		List<Map<String, Object>> boardList = dao.selectBoardList(params);
		int totalCount = dao.selectBoardTotalCount();
		
		Map<String, Object> resultMap = new HashMap();
		resultMap.put("pageIndex", pageIndex);
		resultMap.put("pageFirst", pageFirst);
		resultMap.put("pageBegin", pageBegin);
		resultMap.put("pageEnd", pageEnd);
		resultMap.put("pageLast", pageLast);
		resultMap.put("boardList", boardList);
		resultMap.put("totalCount", totalCount);
		
		return resultMap;
	}

}
