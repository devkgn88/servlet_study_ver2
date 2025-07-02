package com.gn.controller;

import java.io.IOException;
import java.util.List;

import com.gn.dto.Board;
import com.gn.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();

    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nowPage = request.getParameter("nowPage");
		Board param = new Board();
		if(nowPage != null) {
			param.setNowPage(Integer.parseInt(nowPage));
		}
		int totalData = service.selectBoardCount();
		param.setTotalData(totalData);
		
		List<Board> boardList = service.selectBoardList(param);
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", param);
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
