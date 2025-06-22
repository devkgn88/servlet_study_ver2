package com.gn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gn.model.vo.Book;
import com.gn.model.vo.Novel;
import com.gn.model.vo.Poem;

public class BookDAO extends JDBConnection{
	
	public List<Book> list(){
		List<Book> resultList = new ArrayList<Book>();
		String sql = "SELECT isbn,price,type FROM book";
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String type = rs.getString("type");
				String isbn = rs.getString("isbn");
				int price = rs.getInt("price");
				if("N".equals(type)) {
					Novel novel = new Novel(isbn,price);
					resultList.add(novel);
				}else if("P".equals(type)) {
					Poem poem = new Poem(isbn,price);
					resultList.add(poem);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	public int insert(Book book) {
		int result = 0;
		
		String sql= "INSERT INTO book (isbn,price,type) "
				+ "VALUES (?,?,?)";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setInt(2, book.getPrice());
			if(book instanceof Novel) {
				pstmt.setString(3,"N");
			}else if(book instanceof Poem) {
				pstmt.setString(3, "P");
			}
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
