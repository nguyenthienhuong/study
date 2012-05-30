package org.exoplatform.bookstore.service.managedata;

import java.util.List;

import org.exoplatform.bookstore.Entity.Book;

/**
 * 
 * @author huong_nguyenthien
 *
 */
public interface BookStoreManageDataService {
	
	/**
	 * Add new book
	 */
	public Book addNewBook(Book book);
	
	/**
	 * Edit registed book
	 */
	public Book editRegistedBook(Book book);
	
	/**
	 * Delete book
	 */
	public Book deleteBook(Book book);
	
	/**
	 * Get all book in the BookStore by name
	 * 
	 */
	public List<Book> getAllBookByName(String bookName);
	
	/**
	 * Get all book in the BookStore
	 */
	public List<Book> getAllBooks();
	
	/**
	 * Get all Books by Content
	 */
	public List<Book> getAllBookByContent(String content);
	
	/**
	 * Get all books by Category
	 */
	public List<Book> getAllBookByCategory(String category);
	
	/**
	 * Get all books by Author
	 */
	public List<Book> getAllBookByAuthor(String author);
	
	/**
	 * Get all books by Price
	 */
	public List<Book> getAllBookByPrice(Long price);

	
//TODO: Add more methods	
}
