package com.teksystems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class ExceptionExamples {

	public static void main(String[] args) {
				
		try {
			
			readFile();		
			
			String[] st = { "A", "B", "C", "D", "E" };
			st[11] = "X";

			String s = null;
			int l = s.length();
			
			throw new Exception("exception message 1234");

		} catch (NullPointerException npe) {
			
			System.out.println(npe.getMessage());
			// e.printStackTrace();

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("index position is not exsist --> " + e.getMessage());
			// e.printStackTrace();

		} catch (Exception e1) {

			System.out.println(e1.getMessage());
			e1.printStackTrace();
			// e.printStackTrace();

		} finally {
			System.out.println("This is the finally block");
		}
	}

	public static void readFile() throws FileNotFoundException {
		File f = new File("./notexist.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
	}
	
	
	public void testFunction() {
		  FileReader in = null;
	       FileWriter out = null;
	       try {
	   // change below file path as per your file path
	           in = new FileReader("C:/Users/Downloads/testingFile.txt");
	           out = new FileWriter("C:/Users/Downloads/sampleOutput3.txt");
	           int c;
	           while ((c = in.read()) != -1) {
	               out.write(c); // writing data in file
	           }
	           System.out.println("Reading and Writing in a file is done!!!");
	       }
	       catch(Exception e) {
	           System.out.println(e);
	       }
	       finally {
	           if (in != null) {
	               //in.close();
	           }
	           if (out != null) {
	               //out.close();    
	           }
	       }

	}
	
	
	private void someFunction() throws SomeException {
		throw new SomeException("There was a problem in the code");
	}
	
	class SomeException extends Exception {
		
		public SomeException() {
			super();	
		}
		
		public SomeException(String message) {
			super(message);
		}
	}

}
