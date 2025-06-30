package com.gn.common.filter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class PasswordEncryptorWrapper extends HttpServletRequestWrapper{
	
	public PasswordEncryptorWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String result = super.getParameter(name);
		if(name.contains("memberPw")) {
			String ori = super.getParameter(name);
			String enc = getSHA512(super.getParameter(name));
			result = getSHA512(super.getParameter(name));
		}
		return result;
	}
	
	// 단방향 암호화 메소드
	private String getSHA512(String oriVal){
		// Java에서 제공하는 암호화 처리 클래스(MessageDigest)
		MessageDigest md = null;
		try {
			// 적용할 암호화알고리즘 선택하여 객체화
			md = MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// String 데이터를 byte 배열로 자름
		byte[] oriDataByte = oriVal.getBytes();
		// 자른 데이터를 암호화 처리
		md.update(oriDataByte);
		// 암호화 처리된 값을 byte 배열로 가져옴
		byte[] encryptData = md.digest();
		// Base64 인코더를 통해서 byte[]로 출력된 내용을 String으로 변환
		return Base64.getEncoder().encodeToString(encryptData);
	}
}
