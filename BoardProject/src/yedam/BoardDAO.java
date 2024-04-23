package yedam;

import java.util.*;

public class BoardDAO {

	// 필드
	ArrayList<Board> boardList = new ArrayList<>();
	// 메소드

	public ArrayList<Board> getBoardList() {return boardList;}

	public void setBoardList(ArrayList<Board> boardList) {this.boardList = boardList;}

}
