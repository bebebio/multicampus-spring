package dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.Board;

public class BoardDaoTest {
	
	public static void main(String[] args) {
		try {
			IBoardDao dao = new BoardDao();
			
			Map<String, Object> params = new HashMap();
//			params.put(Board.PASS, "gildong123");
//			params.put(Board.NAME, "홍길동");
//			params.put(Board.EMAIL, "honggildong@example.com");
//			params.put(Board.TITLE, "");
//			params.put(Board.CONTENT, "내용");
//			
//			System.out.println("- insert : " + dao.insertBoard(params));
//			System.out.println("  -> num : " + params.get(Board.NUM));
//			System.out.println("  -> " + dao.selectBoard(params));
//			
//			params.put(Board.CONTENT, "내용수정");
//			System.out.println("- update : " + dao.updateBoard(params));
//			System.out.println("  -> " + dao.selectBoard(params));
//			
//			System.out.println("- delete : " + dao.deleteBoard(params));
//			
//			System.out.println("-----");
//			dao.selectBoardList(params).forEach(board -> {
//				System.out.println(board);
//			});
			
			List<String> titles = Arrays.asList("제목없음1");
			params.put("titles", titles);
			
			dao.selectBoardByTitle(params).forEach(board -> {
				System.out.println(board);
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
