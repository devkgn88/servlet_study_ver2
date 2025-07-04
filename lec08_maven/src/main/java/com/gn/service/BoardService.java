package com.gn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dao.BoardDao;
import com.gn.dto.Attach;
import com.gn.dto.Board;

public class BoardService {
	private BoardDao boardDao = new BoardDao();

	public List<Board> selectBoardList(Board param) {
		return boardDao.selectBoardList(param);
	}
	
	public int selectBoardCount(Board param) {
		return boardDao.selectBoardCount(param);
	}
	
	// 게시글 + 파일 트랜잭션 처리
	public int createBoardWithFile(Board board, Attach attach) {
		SqlSession session = SqlSessionTemplate.getSqlSession(false);
		int result = 0;
		
		try {
			// 1. 게시글 등록
			result = boardDao.insertBoard(session,board);
						
			if(result > 0 && attach != null) {
				// 2. 파일 정보 등록
				attach.setBoardNo(board.getBoardNo());
				result = boardDao.insertAttach(session, attach);
			}
			
			if(result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return result;
	}
	
	public Board selectBoardDetail(int boardNo) {
		return boardDao.selectBoardDetail(boardNo);
	}
	
	public Attach selectAttachOne(int boardNo) {
		return boardDao.selectAttachOne(boardNo);
	}
}
