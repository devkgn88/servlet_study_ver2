package com.gn.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

import com.gn.dto.Attach;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class AttachService {
	// 업로드할 디렉토리 반환
	public static File getUploadDirectory() {
		String dirPath = "C://upload/board";
		
		// 파일을 업로드할 디렉토리 생성
		File uploadDir = new File(dirPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		return uploadDir;
	}
	
	// request에서 넘어온 정보중에 파일 추출(단일)
	public static Attach handleUploadFile(HttpServletRequest request,
			File uploadDir) throws ServletException, IOException{
		// form에서 파일(name 속성 기준) 가져오기
		Part filePart = request.getPart("board_file");
		if(filePart.getSize() > 0) {
			return getFileMeta(filePart,uploadDir);
		}
		return null;	
	}
	
	
	// request에서 넘어온 정보중에 파일 추출(복수)
	public static List<Attach> handleUploadFiles(HttpServletRequest request,
			File uploadDir) throws ServletException, IOException {
		// form에서 파일 가져오기, 파일 처리
		Collection<Part> parts = request.getParts();
		List<Attach> files = new ArrayList<Attach>();
		for(Part part : parts) {
			if(part.getName().equals("board_file") && part.getSize() > 0) {
				files.add(getFileMeta(part,uploadDir));
			}
		}
		return files;
	}
	
	// 파일에서 메타 데이터 추출
	public static Attach getFileMeta(Part part, File uploadDir)
		throws IOException {
		
		// 원본 파일 이름
		String oriName = part.getSubmittedFileName();
		// 파일 확장자
		String ext = FilenameUtils.getExtension(oriName);
		// 확장자 제외 파일 이름
		String fileName = oriName.substring(0,oriName.indexOf("."));
		// UUID 사용하여 중복 방지
		String saveName = UUID.randomUUID().toString().replace("-", "");
		File file = new File(uploadDir, saveName+"."+ext);
		
		// 파일 저장
		try(InputStream input = part.getInputStream();
			OutputStream output = Files.newOutputStream(file.toPath())){
			
			// output 경로에 input에 담긴 데이터 보내기
			input.transferTo(output);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Attach a = new Attach();
		a.setOriName(oriName);
		a.setReName(saveName);
		return a;

	}
	
	// 파일 단일 정보 추출
	public Attach uploadFile(HttpServletRequest request) throws ServletException, IOException {
        File uploadDir = getUploadDirectory();
        return handleUploadFile(request, uploadDir);
    }

	
}
