package com.gn.controller;

import java.io.File;
import java.io.IOException;

import com.gn.dto.Attach;
import com.gn.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    public BoardDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("no"));
		
		// 1. 첨부파일 조회
		Attach attach = service.selectAttachOne(boardNo);
		
		// 2. 서버에서 실제 파일 삭제
		File file = new File("C:\\upload\\board\\"+attach.getReName());
		if(file.exists()) file.delete();
		
		// 3. DB에서 첨부파일 + 게시글 삭제
		int result = service.deleteBoardWithAttach(boardNo);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
