package org.exoplatform.bookstore.service.managedata.impl;

import java.util.List;

import org.exoplatform.bookstore.Entity.Book;
import org.exoplatform.bookstore.service.managedata.BookStoreManageDataService;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.test.JCRDataStorage;
import org.exoplatform.bookstore.service.managedata.impl.*;

public class BookStoreManageDataServiceImpl implements BookStoreManageDataService {
	private JCRDataStorage jcrDataStorage = new JCRDataStorage();
	  public BookStoreManageDataServiceImpl(RepositoryService rservice) {
	    jcrDataStorage.setRepositoryService(rservice);
	  }

	@Override
	public Book addNewBook(Book book) {
		return jcrDataStorage.addBook(book);
	}

	@Override
	public Book editRegistedBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book deleteBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBookByName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBookByContent(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBookByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBookByPrice(Long price) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
