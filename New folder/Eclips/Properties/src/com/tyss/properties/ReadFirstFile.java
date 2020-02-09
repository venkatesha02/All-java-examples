/**
 * 
 */
package com.tyss.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Administrator
 *
 */
public class ReadFirstFile {

	public static void main(String[] args) {

		try {
			FileInputStream input = new FileInputStream("db.properties");
			Properties pro = new Properties();
			pro.load(input);
			String user =pro.getProperty("user");
			String pass = pro.getProperty("password");
			System.out.println("The Name is "+user);
			System.out.println("The Password is "+pass);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}// end of main()

}// end of class
