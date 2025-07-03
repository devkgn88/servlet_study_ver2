package com.gn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import com.gn.dto.Attach;
import com.gn.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    public FileDownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파일 정보 조회
        int boardNo = Integer.parseInt(request.getParameter("no"));
        Attach attach = service.selectAttachOne(boardNo);

        // 2. 유효성 검사 - 파일 경로가 비어있을 경우
        String filePath = "C:\\upload\\board\\"+attach.getReName();
        if(filePath == null || filePath.trim().equals("")) {
        	response.sendError(HttpServletResponse.SC_BAD_REQUEST); 
            return;
        }
        
        File file = new File(filePath);
        
        // 3. 파일 존재 유무 확인
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        // 4. 다운로드용 응답 헤더 설정
        response.setContentType("application/octet-stream");
        response.setContentLength((int) file.length());

        // 5. 파일명 인코딩 (한글깨짐 방지)
        String encodedFileName = URLEncoder.encode(attach.getOriName(), "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");

        // 6. 파일 데이터를 전송
        try (FileInputStream fis = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
            	out.write(buffer, 0, bytesRead);
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
