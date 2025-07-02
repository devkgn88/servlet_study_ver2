package com.gn.service;

import java.util.List;

import com.gn.dao.BoardDao;
import com.gn.dto.Board;

public class BoardService {
	private BoardDao dao = new BoardDao();

	public List<Board> selectBoardList() {
		return dao.selectBoardList();
	}
}
