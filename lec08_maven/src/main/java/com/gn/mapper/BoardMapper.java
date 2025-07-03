package com.gn.mapper;

import java.util.List;

import com.gn.dto.Attach;
import com.gn.dto.Board;

public interface BoardMapper {
	List<Board> selectBoardList(Board param);
	
	int insertBoard(Board param);
	
	int insertAttach(Attach param);
	
	int selectBoardCount(Board param);
}
