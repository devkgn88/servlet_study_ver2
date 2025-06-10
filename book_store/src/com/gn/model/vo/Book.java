package com.gn.model.vo;

public class Book {
	private String isbn;
	private int price;
	
	public Book() {}
	
	public Book(String isbn, int price) {
		this.isbn = isbn;
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void printInfo() {
		recoverMissingDigit();
		System.out.print("ISBN : "+isbn+", 가격 : "+price+"원");
	}
	
	public void recoverMissingDigit() {
		if(isbn.indexOf("*") != -1) {
			
			String result = "";
			
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
					result = String.valueOf(i);
					break;
				}
			}
			
			this.isbn = isbn.replace("*", result);
		}
	}
}
