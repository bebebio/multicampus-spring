package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.IBoardService;
import vo.BoardListVo;
import vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private IBoardService boardService;
	
	@RequestMapping("/selectBoardList.do")
	public ModelAndView selectBoardList(BoardVo boardVo) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		BoardListVo boardListVo = boardService.selectBoardList(boardVo);
		mav.addObject("boardListVo", boardListVo);
		
		mav.setViewName("/board/boardList");
		
		return mav;
	}
	
}
