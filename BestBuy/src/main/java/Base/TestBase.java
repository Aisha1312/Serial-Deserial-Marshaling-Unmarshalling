package Base;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import io.cucumber.java.Before;



public class TestBase {
	
	public static Properties prop;
	public static Logger log;
	
	
	 public static void init()
	 {
	        //PropertyConfigurator.configure("src/main/java/Configurations/log4j.properties");
	        prop=new Properties();
	        try {
	            FileInputStream file = new FileInputStream("src\\main\\java\\Configurations\\configuration.properties");
	            prop.load(file);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

}
