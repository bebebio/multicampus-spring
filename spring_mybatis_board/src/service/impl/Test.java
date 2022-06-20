package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import constant.Board;
import service.IBoardService;

public class Test {
	
	public static void main(String[] args) {		
		try {
			String configPath = "/context/applicationContext.xml";
			ApplicationContext context = new GenericXmlApplicationContext(configPath);	
			IBoardService service = context.getBean("boardServiceImpl", IBoardService.class);
			
			Map<String, Object> params = new HashMap();
			params.put(Board.PASS, "admin123");
			params.put(Board.NAME, "홍길동");
			params.put(Board.EMAIL, "honggil@example.com");
			params.put(Board.TITLE, "제목");
			params.put(Board.CONTENT, "내용");
			
			boolean insertResult = service.insertBoard(params);
			System.out.println("- insertResult : " + insertResult);
			System.out.println("  -> " + params);
			
			params.put(Board.TITLE, "제목(수정)");
			boolean updateResult = service.updateBoard(params);
			System.out.println("- updateResult : " + updateResult);
			
			Map<String, Object> boardMap = service.selectBoard(params);
			System.out.println("- boardMap : " + service.selectBoard(params));
			
			params.put("paegSkip", 0);
			params.put("pageSize", 10);
			
			Map<String, Object> resultList = (Map<String, Object>) service.selectBoardList(params);
			List<Map<String, Object>> boardList = (List<Map<String, Object>>) resultList.get("boardList");
 			for(Map<String, Object> board : boardList) {
				System.out.println(board);
			}
			
			boolean deleteResult = service.deleteBoard(params);
			System.out.println("- deleteResult : " + deleteResult);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
