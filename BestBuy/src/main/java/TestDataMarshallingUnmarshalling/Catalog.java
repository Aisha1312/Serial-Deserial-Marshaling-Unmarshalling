package TestDataMarshallingUnmarshalling;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="catalog")
public class Catalog {
	 
//	private List<Book> book;
//	
//	public List<Book> getBook() {
//		return book;
//	}
//
//	public void setBook(List<Book> book) {
//		this.book = book;
//	}
//
//	public Catalog(List<Book> book) {
//		super();
//		this.book = book;
//	}
	
	private ArrayList<Book> book;
	
	@XmlElement(name="book")
	public ArrayList<Book> getBook() {
		return book;
	}

	public void setBook(ArrayList<Book> myBooks) {
		this.book = myBooks;
	}

	public Catalog(Book book1) {
		super();
	}

	public Catalog() {
		super();
	}	
}
