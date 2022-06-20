package service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import constant.Board;
import service.IBoardService;

public class BoardServiceImplTest {
	
	public static void main(String[] args) {
		try {
			IBoardService service = new BoardServiceImpl();
			
			for(int i=0; i<100; i++) {
				service.insertBoard("admin123", "홍길동", "honggildong@example.com", "제목", "내용");
			}
			
			Map<String, Object> resultMap = service.selectBoardList(3, 5);
			Set<String> keySet = resultMap.keySet();
			for(String key : keySet) {
				if(key.equals("boardList")) {
					List<Map<String, Object>> boardList = 
							(List<Map<String, Object>>) resultMap.get(key);
					System.out.println("key=" + key + ", value=");
					for(Map<String, Object> boardMap : boardList) {
						System.out.println(boardMap);
					}
				} else {
					System.out.println("key=" + key + ", value=" + resultMap.get(key));					
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
