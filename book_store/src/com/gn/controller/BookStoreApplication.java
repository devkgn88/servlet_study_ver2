package com.gn.controller;

import java.util.List;
import java.util.Scanner;

import com.gn.model.vo.Book;
import com.gn.model.vo.Novel;
import com.gn.model.vo.Poem;
import com.gn.service.BookService;
import com.gn.service.BookServiceImpl;

public class BookStoreApplication {
	
	private static List<Book> resultList = null;
	private static BookService bookService = new BookServiceImpl();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.print("책 종류를 입력하세요 (소설/시): ");
			String type = sc.nextLine().trim();

			if (!type.equals("소설") && !type.equals("시")) {
				System.out.println("잘못된 종류입니다. 다시 입력해주세요.");
				continue;
			}

			System.out.print("ISBN을 입력하세요 (13자리, * 포함 가능): ");
			String isbn = sc.nextLine().trim();

			if (!isValidISBN(isbn)) {
				System.out.println("유효하지 않은 ISBN 형식입니다. 다시 입력해주세요.");
				continue;
			}

			System.out.print("가격을 입력하세요: ");
			int price;

			try {
				price = Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("가격은 숫자로 입력해야 합니다. 다시 입력해주세요.");
				continue;
			}

			Book book = null;

			if (type.equals("소설")) {
				book = new Novel(isbn, price);
			} else if (type.equals("시")) {
				book = new Poem(isbn, price);
			}

			bookService.insert(book);

			System.out.print("입력을 종료하시겠습니까? (y/Y 입력 시 종료): ");
			String exit = sc.nextLine().trim();

			if (exit.equalsIgnoreCase("y")) {
				break;
			}
		}

		System.out.println("\n===== 도서 목록 =====");
		int total = 0;

		resultList = bookService.list();
		
		for (Book b : resultList) {
			b.printInfo();
			System.out.println();
			total += b.getPrice();
		}

		if (!resultList.isEmpty()) {
			double avg = (double) total / resultList.size();
			System.out.printf("\n총 평균 가격 : %.2f원\n", avg);
		} else {
			System.out.println("등록된 도서가 없습니다.");
		}

		sc.close();
	}


	private static boolean isValidISBN(String isbn) {
		
		boolean result = true;
		
		// isbn의 길이가 13자가 아닌 경우
		if (isbn.length() != 13) result = false;
		
		// *이 하나 이상인 경우
		if(isbn.length() -1 > isbn.replace("*","").length()) {
			result = false;
		}
		
		// *이 하나 있는 경우
		if(isbn.indexOf("*") != -1) {
						
			for(int i = 0 ; i <= 9 ; i++) {
				String temp = isbn.replace("*", String.valueOf(i));
				String[] arr = temp.split("");
				int sum = 0;
				
				for(int j = 0 ; j < arr.length ; j++) {
					if(j%2 == 0) {
						sum += Integer.parseInt(arr[j]);
					} else {
						sum += Integer.parseInt(arr[j])*3;
					}
				}
				
				if(sum%10 == 0) {
					result = true;
					break;
				}else {
					result = false;
				}
			}
			
			
		}
		
		return result;

	}
}
