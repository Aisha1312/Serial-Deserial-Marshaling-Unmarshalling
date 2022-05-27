package StepDefenition;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import TestDataMarshallingUnmarshalling.Book;
import TestDataMarshallingUnmarshalling.Catalog;
import io.cucumber.java.en.Given;

public class MarshallingSteps {

	 	@Given("marshalling function is called")
	    public void marshalling_function_is_called() {
		try {
			Book book1 = new Book(1, "Aisha", "5 steps for success", "personality development", 1000, "13-12-1996",
					"Aisha is a good girl");
			Book book2 = new Book(1, "Roohi", "5 steps for success", "personality development", 1000, "13-10-1995",
					"Roohi is a good girl");
			
			ArrayList<Book> myBooks = new ArrayList<Book>();
			myBooks.add(book1);
			myBooks.add(book2);
			Catalog catalog = new Catalog();
			catalog.setBook(myBooks);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File file = new File("src\\main\\java\\xmlFiles\\catalog.xml");

			marshaller.marshal(catalog, file);

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
