package com.tyss.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FirstPropertyFile {

	public static void main(String[] args) {

		try {
			FileOutputStream stream = new FileOutputStream("first.properties");
			Properties pro = new Properties();
			pro.setProperty("name", "Venki");
			pro.setProperty("mobile", "9874563210");
			pro.store(stream, "new file");
		
			System.out.println("Done");
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}// end of main()

}// end of class
