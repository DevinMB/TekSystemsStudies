package com.teksystems;

import java.io.File;

public class FileExamples {
	
	public static void main(String[] args) {
		
		// ./ means the current file directory
		// ../ means the parent directory
		// the difference between / and \
		// windows uses \ and (a mac and all linux systes) use the /
		// java figures out slashes pretty good.
		// problem with windows is that the \ character is also the escape character in a string
		// thus windows users must \\ instead of single slash
		System.out.println("Operating system slash is " + File.separator);
		
		File macRoot = new File("/");
		File windowsRoot = new File("\\development");
		
		for ( File file : windowsRoot.listFiles()) {
			System.out.println(file.getAbsolutePath() + " is directory " + file.isDirectory());
		}
		
		System.out.println("================================");
		File desktop = new File("C:\\Users\\eric\\Desktop\\test.txt");
		System.out.println(desktop.getName() + " File exists " + desktop.exists());
		System.out.println(desktop.getAbsolutePath() + " File exists " + desktop.exists());
		
		File temp = new File("./newfile.txt" );
	}
}
