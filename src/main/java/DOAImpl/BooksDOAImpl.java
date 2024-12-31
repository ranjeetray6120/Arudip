package DOAImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DOA.BooksDOA;
import model.Books;
import utility.ConnectionProvider;

public class BooksDOAImpl implements BooksDOA {

	@Override
	public void addbooks(Books book) {
		String sql = "INSERT INTO books(title, author , price) values(?,?,?)";
		
		try(Connection conn = ConnectionProvider.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, book.getTital());
			stmt.setString(2, book.getAuthor());
			stmt.setDouble(3, book.getPrice());
			
			int rowAffected = stmt.executeUpdate();
			System.out.println("Book added successfully. Row affected: "+rowAffected);
		}catch(SQLException e) {
			e.printStackTrace();
			 System.out.println("Error adding the book: " + book.getTital());
		}
	}

	@Override
	public List<Books> getAllBooks() {
		String sql = "SELECT * FROM books";
		List<Books> booksList = new ArrayList<>(); 
		try(Connection conn = ConnectionProvider.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
		
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int bookid = rs.getInt("book_id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					double price = rs.getDouble("price");
					
					Books book = new Books(bookid,title,author,price);
					booksList.add(book);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return booksList;
	}

	@Override
	public Books getBookbybookid(int bookId) {
	    Books books = null;
	    String sql = "SELECT * FROM books WHERE book_id = ?";
	    
	    try (Connection conn = ConnectionProvider.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, bookId);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) { // Move to the first row of the result set
	                books = new Books(
	                    rs.getInt("book_id"),
	                    rs.getString("title"),
	                    rs.getString("author"),
	                    rs.getDouble("price")
	                );
	            } else {
	                System.out.println("No book found with the given ID: " + bookId);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return books;
	}


	@Override
	public void deletebookbyid(int bookId) {
		
		String sql = "delete from books where book_id = ?";
		if(bookId<=0) {
			throw new IllegalArgumentException("Invalid Book ID.");
		}
		try(Connection conn = ConnectionProvider.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, bookId);
			int rowDetele = stmt.executeUpdate();
			System.out.println("Delete row "+rowDetele);
			}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	

}
