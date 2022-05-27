package StepDefenition;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import TestDataMarshallingUnmarshalling.Book;
import TestDataMarshallingUnmarshalling.Catalog;
import io.cucumber.java.en.Given;

public class UnmarshallingSteps {

	@Given("unmarshalling function is called")
	public void unmarshalling_function_is_called() {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Catalog catalog = (Catalog) unmarshaller.unmarshal(new File("src\\main\\java\\xmlFiles\\catalog.xml"));
			System.out.println("Catalog information");
			List<Book> books = catalog.getBook();
			System.out.println(books.get(0).getAuthor());
			System.out.println(books.get(1).getAuthor());
		} 
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}

}
