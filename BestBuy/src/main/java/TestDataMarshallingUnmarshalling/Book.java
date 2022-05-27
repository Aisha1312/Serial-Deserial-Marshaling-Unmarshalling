package TestDataMarshallingUnmarshalling;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Book {

	private int id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private String publishDate;
	private String description;

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@XmlElement
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@XmlElement
	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Book(int id, String author, String title, String genre, double price, String publishDate,
			String description) {

		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.publishDate = publishDate;
		this.description = description;
	}

	public Book() {

	}
}
