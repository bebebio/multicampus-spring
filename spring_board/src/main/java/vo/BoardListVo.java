package vo;

import java.util.List;

public class BoardListVo extends CommonVo {
	
	private List<BoardVo> boardList;

	public List<BoardVo> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVo> boardList) {
		this.boardList = boardList;
	}

	@Override
	public String toString() {
		return "BoardListVo [boardList=" + boardList + "]";
	}
	
}
