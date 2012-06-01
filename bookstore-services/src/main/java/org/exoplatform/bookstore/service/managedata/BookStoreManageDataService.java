package org.exoplatform.bookstore.service.managedata;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.Value;

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
	public Node addNewBook(Book book);
	
	/**
	 * Edit registed book
	 */
	public Book editRegistedBook(Book book);
	
	/**
	 * Delete book
	 * @throws Exception 
	 */
	public Book deleteBook(String bookName) throws Exception;
	
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

	public Node addNewBook(String bookId, String bookName, String bookAuthor,
			Calendar bookPublisherDate, Long pricePublisher, Long priceSell,
			String bookCategory) throws Exception; 

	
//TODO: Add more methods	
}
