package org.exoplatform.bookstore.service.managedata.impl;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Session;

import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.jcr.core.ManageableRepository;
import org.exoplatform.services.jcr.ext.common.SessionProvider;
import org.exoplatform.services.jcr.util.IdGenerator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.test.BookNodeTypes;
import org.exoplatform.test.JCRDataStorage;
import org.exoplatform.test.entity.Book;
import org.exoplatform.test.exception.DuplicateBookException;
import org.exoplatform.test.utils.PropertyReader;
import org.exoplatform.test.utils.Utils;
import org.exoplatform.bookstore.Entity.*;

public class JCRDataStorage<ManageableRepository, Session, repoService, Node, RepositoryService> {
	private static final Log log = ExoLogger.getLogger(JCRDataStorage.class);
	  public static final String DEFAULT_PARENT_PATH = "/bookStore"; 
	  
	  private RepositoryService repoService;
	  
	  public JCRDataStorage() {
	  }
	  
	  void setRepositoryService(RepositoryService repoService) {
	    this.repoService = repoService;
	  }
	  public void init() {
		    SessionProvider sProvider = SessionProvider.createSystemProvider();
		    Node node = null;
		    try {
		      node = getNodeByPath(DEFAULT_PARENT_PATH, sProvider);
		    } catch (PathNotFoundException e) {
		      // If the path not exist then create new path
		      try {
		        node = getNodeByPath("/", sProvider);
		        node.addNode("bookStore", BookNodeTypes.EXO_BOOK_STORE);
		        node.getSession().save();
		      } catch (Exception e1) {
		        e1.printStackTrace();
		      }
		    } catch (Exception e) {
		      log.error("Failed to init BookStore jcr node's path", e);
		    }  finally {
		      sProvider.close();
		    }
		  }
	  private Node getNodeByPath(String nodePath, SessionProvider sessionProvider) throws Exception {
		    return (Node) getSession(sessionProvider).getItem(nodePath);
		  }
		  
		  private Session getSession(SessionProvider sprovider) throws Exception {
		    ManageableRepository currentRepo = repoService.getCurrentRepository();
		    return sprovider.getSession(currentRepo.getConfiguration().getDefaultWorkspaceName(), currentRepo);
		  }
		  private <Node> Book createBookByNode(Node bookNode) throws Exception {
			    if (bookNode == null) {
			      return null;
			    }
			      
			    Book bookNew = new Book();
			    bookNew.setBookName(bookNode.getName());
			    
			    PropertyReader reader = new PropertyReader(bookNode);
			    bookNew.setBookName(reader.string(BookNodeTypes.BOOK_NAME));
			    bookNew.setBookAuthor(reader.string(BookNodeTypes.BOOK_AUTHOR));
			    bookNew.setCategory(Utils.bookCategoryStringToEnum(reader.string(BookNodeTypes.BOOK_CATEGORY)));
			    bookNew.setContent(reader.string(BookNodeTypes.BOOK_CONTENT));
			    bookNew.setDatePublisher(reader.string(BookNodeTypes.PUBLISHER_YEAR));
			    bookNew.setPricePublisher(reader.string(BookNodeTypes.PRICE_PUBLISHER));
			    bookNew.setPriceSell(reader.string(BookNodeTypes.PRICE_SELL));
			    
			    return bookNew;
			  }
		  
		  public Book addBook(Book book) throws Exception {
			    SessionProvider sProvider = SessionProvider.createSystemProvider();
			    if (isExistBookName(book.getBookName(), sProvider)) {
			      throw new DuplicateBookException(String.format("Book %s is existed", book.getBookName()));
			    }
			    
			    String nodeId = IdGenerator.generate();
			    book.setId(nodeId);
			    
			    try {
			      Node parentNode = getNodeByPath(DEFAULT_PARENT_PATH, sProvider);
			      Node bookNode = parentNode.addNode(nodeId, BookNodeTypes.EXO_BOOK);
			      bookNode.setProperty(BookNodeTypes.BOOK_NAME, book.getBookName());
			      bookNode.setProperty(BookNodeTypes.BOOK_CATEGORY, Utils.bookCategoryEnumToString(book.getCategory()));
			      bookNode.setProperty(BookNodeTypes.BOOK_CONTENT, book.getContent());
			      bookNode.setProperty(BookNodeTypes.BOOK_AUTHOR, book.getBookAuthor());
			      bookNode.setProperty(BookNodeTypes.PUBLISHER_YEAR,book.getDatePublisher());
			      bookNode.setProperty(BookNodeTypes.PRICE_PUBLISHER,book.getPricePublisher());
			      bookNode.setProperty(BookNodeTypes.PRICE_SELL,book.getPriceSell());
			     
			      parentNode.getSession().save();
			      return book;
			    } catch (PathNotFoundException e) {
			      return null;
			    } catch (Exception e) {
			      log.error("Failed to add book", e);
			      return null;
			    } finally {
			      sProvider.close();
			    }
			  }
			  
}
