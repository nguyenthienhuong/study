package org.exoplatform.bookstore.service.managedata.impl;

import java.util.Calendar;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.Session;

import org.exoplatform.bookstore.Entity.Book;
import org.exoplatform.bookstore.service.managedata.BookStoreManageDataService;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.jcr.core.ManageableRepository;
import org.exoplatform.services.jcr.ext.app.SessionProviderService;
import org.exoplatform.services.jcr.ext.common.SessionProvider;

public class BookStoreManageDataServiceImpl implements BookStoreManageDataService {
	
	private RepositoryService repositoryService;
	private SessionProviderService sessionProviderService;
	
	public BookStoreManageDataServiceImpl(RepositoryService repositoryService,SessionProviderService sessionProviderService ){
		this.repositoryService=repositoryService;
		this.sessionProviderService=sessionProviderService;
	}
	
	@Override
	public Node addNewBook(String bookId, String bookName, String bookAuthor, Calendar bookPublisherDate, Long pricePublisher,Long priceSell, String bookCategory ) throws Exception{
		ManageableRepository repository;
		
			repository = repositoryService.getRepository(BookNodeTypes.REPOS);
			SessionProvider sessionProvider = sessionProviderService.getSystemSessionProvider(null);
			Session session = sessionProvider.getSession(BookNodeTypes.WORK_SPACE, repository);
			Node rootNode = session.getRootNode();
			Node bookstore = rootNode.hasNodes() ? rootNode.getNode(bookId) : rootNode.addNode(bookId);
			Node book = bookstore.addNode(bookId);
			book.setProperty(BookNodeTypes.BOOK_NAME, bookName);
			book.setProperty(BookNodeTypes.BOOK_AUTHOR, bookAuthor);
			book.setProperty(BookNodeTypes.PUBLISHER_YEAR, bookPublisherDate);
			book.setProperty(BookNodeTypes.BOOK_CATEGORY, bookCategory);
			book.setProperty(BookNodeTypes.PRICE_PUBLISHER, pricePublisher);
			book.setProperty(BookNodeTypes.PRICE_SELL, priceSell);
			return book;
		
	}
	
	@Override
	public Book deleteBook(String bookName) throws Exception{
		ManageableRepository repository;
		
		repository = repositoryService.getRepository(BookNodeTypes.REPOS);
		SessionProvider sessionProvider = sessionProviderService.getSystemSessionProvider(null);
		Session session = sessionProvider.getSession(BookNodeTypes.WORK_SPACE, repository);
		Node rootNode = session.getRootNode();
		Node bookstrore = rootNode.hasNode(bookName) ? rootNode.getNode(bookName) : null;
		if(bookstrore==null){
			return null;
		}
		else{
			bookstrore.remove();
			session.save();
		}
		if(session!=null){
			session.logout();
			
		}
		
		
		return null;
	}

	@Override
	public Book editRegistedBook(Book book) {
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

	@Override
	public Node addNewBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
