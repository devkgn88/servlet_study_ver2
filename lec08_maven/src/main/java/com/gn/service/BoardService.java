package com.gn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dao.BoardDao;
import com.gn.dto.Attach;
import com.gn.dto.Board;

public class BoardService {
	private BoardDao boardDao = new BoardDao();

	public List<Board> selectBoardList() {
		return boardDao.selectBoardList();
	}
	
	// 게시글 + 파일 트랜잭션 처리
	public int createBoardWithFile(Board board, Attach attach) {
		SqlSession session = SqlSessionTemplate.getSqlSession(false);
		int result = 0;
		
		try {
			// 1. 게시글 등록
			result = boardDao.insertBoard(session,board);
			
			System.out.println("1 : "+result);
			
			if(result > 0 && attach != null) {
				System.out.println("2 : "+result);
				// 2. 파일 정보 등록
				attach.setBoardNo(board.getBoardNo());
				result = boardDao.insertAttach(session, attach);
				System.out.println("3 : "+result);
			}
			System.out.println("4 : "+result);
			
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
}
