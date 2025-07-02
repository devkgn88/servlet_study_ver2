package com.gn.controller;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.gn.dto.Attach;
import com.gn.dto.Board;
import com.gn.service.BoardService;
import com.gn.service.AttachService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 20
)
@WebServlet("/boardWrite")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AttachService fileService = new AttachService();
    private BoardService boardService = new BoardService();

       
    public BoardWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/board/write.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 게시글 정보 추출
        String boardTitle = request.getParameter("boardTitle");
        String boardContent = request.getParameter("boardContent");
        int boardWriter = Integer.parseInt(request.getParameter("boardWriter"));

        Board board = new Board();
        board.setBoardTitle(boardTitle);
        board.setBoardContent(boardContent);
        board.setBoardWriter(boardWriter);
        
        // 2. 파일 정보 추출
        Attach file = fileService.uploadFile(request);

        JSONObject obj = new JSONObject();
        obj.put("res_code", "500");
        obj.put("res_msg", "게시글 등록중 오류가 발생했습니다.");

       // 3. 게시글과 파일 정보 기반으로 데이터 추가
        int result = boardService.createBoardWithFile(board,file);
		if(result > 0) {
			obj.put("res_code", "200");
			obj.put("res_msg", "게시글 등록 성공!!");
		}
        
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
        
	}
}
