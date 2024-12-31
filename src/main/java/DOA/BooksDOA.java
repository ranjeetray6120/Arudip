package DOA;

import java.util.List;

import model.Books;

public interface BooksDOA {
	void addbooks(Books book);
	List<Books> getAllBooks();
	Books getBookbybookid(int bookId);
	void deletebookbyid(int bookId);
}
