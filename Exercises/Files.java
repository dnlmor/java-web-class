package Exercises;

import java.io.*;
import java.util.Scanner;

public class Files {
	public static void main(String[] args) throws IOException {

		File fileObj1 = new File("C:\\Users\\earuvai\\Downloads\\FileFolder\\NewFile.txt");
		try {
			if (fileObj1.createNewFile()) {
				System.out.println("NewFile Created!");
			} else {
				System.out.println("Already exists");
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();

		}
		
		// Method - 1 
		FileWriter fWrite = new FileWriter("C:\\Users\\earuvai\\Downloads\\FileFolder\\NewFile1.txt");
		fWrite.write("Java has a content now!!" + "\n");
		fWrite.append("Appending as a second line!" + "\n");
		fWrite.write("Java has a content now as a 3rd line!!");
		fWrite.close();

		// Method - 2 
		Scanner sc = new Scanner(System.in);
		FileWriter file = new FileWriter("C:\\Users\\earuvai\\Downloads\\FileFolder\\NewFile.txt");
		String data = "";
		BufferedWriter bf = null;
		try {
			System.out.println("Enter the content:");
			bf = new BufferedWriter(file);
			while (!data.contentEquals("/")) {
				data = sc.nextLine();
				bf.write(data, 0, data.length());
				bf.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		bf.close();
		sc.close();

		
		char[] array = new char[100];
		try {
			FileReader readFile = new FileReader("C:\\Users\\earuvai\\Downloads\\FileFolder\\NewFile.txt");

			// Reads characters
			readFile.read(array);
			System.out.println("Data in the file:");
			System.out.println(array);
			readFile.close();
		} catch (Exception e) {
			e.getStackTrace();
		}

		
		File filedelete = new File("C:\\Users\\earuvai\\Downloads\\FileFolder\\NewFile1.txt");

		boolean value = filedelete.delete();
		if (value) {
			System.out.println("The File is deleted.");
		} else {
			System.out.println("The File is not deleted.");
		}


	}
}
