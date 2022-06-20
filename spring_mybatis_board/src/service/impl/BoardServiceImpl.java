package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.IBoardDao;
import service.IBoardService;

@Component
public class BoardServiceImpl implements IBoardService {
	
	@Autowired
	private IBoardDao boardDao;
	
	@Override
	public boolean insertBoard(Map<String, Object> params) throws Exception {
		return boardDao.insertBoard(params) > 0 ? true : false;
	}

	@Override
	public boolean updateBoard(Map<String, Object> params) throws Exception {
		return boardDao.updateBoard(params) > 0 ? true : false;
	}

	@Override
	public boolean deleteBoard(Map<String, Object> params) throws Exception {
		return boardDao.deleteBoard(params) > 0 ? true : false;
	}
	
	@Override
	public Map<String, Object> selectBoard(Map<String, Object> params) throws Exception {
		return boardDao.selectOne(params);
	}

	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> params) throws Exception {
		Map<String, Object> resultMap = new HashMap();
		
		List<Map<String, Object>> boardList = boardDao.selectList(params);
		
		resultMap.put("boardList", boardList);
		
		return resultMap;
	}

}
