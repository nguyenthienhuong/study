package org.exoplatform.bookstore.Entity;

import java.util.Date;

public class Book {
	public enum CATEGORY {
	    NOVEL, ROMANCE, COMICS, TECHNICAL, MATHS, INFOMATIC, HISTORY, SPORT
	  }
	
	private String bookName;
	private String bookAuthor;
	private Date datePublisher;
	private Long pricePublisher;
	private Long priceSell;
	private CATEGORY category;
	private String content;
	
	
	public Book(String bookName, String bookAuthor,String content, Date datePublisher, Long pricePublisher, Long priceSell, CATEGORY category){
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.content=content;
		this.datePublisher=datePublisher;
		this.pricePublisher=pricePublisher;
		this.priceSell=priceSell;
		this.category=category;
	}
									
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Date getDatePublisher() {
		return datePublisher;
	}
	public void setDatePublisher(Date datePublisher) {
		this.datePublisher = datePublisher;
	}
	public Long getPricePublisher() {
		return pricePublisher;
	}
	public void setPricePublisher(Long pricePublisher) {
		this.pricePublisher = pricePublisher;
	}
	public Long getPriceSell() {
		return priceSell;
	}
	public void setPriceSell(Long priceSell) {
		this.priceSell = priceSell;
	}
	public CATEGORY getCategory() {
		return category;
	}
	public void setCategory(CATEGORY category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	 	
}
