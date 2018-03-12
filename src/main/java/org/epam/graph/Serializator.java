package org.epam.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializator {

	public static void serData(String file_name, Object obj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(file_name+".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			fileOut.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Exception of input/output");
			System.exit(2);
		}
	}

	public static Object deserData(String file_name) {
		Object retObject = null;
		try {
			FileInputStream fileIn = new FileInputStream(file_name+".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			retObject = in.readObject();
			fileIn.close();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Exception of input/output");
			System.exit(2);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			System.exit(3);
			}
		return retObject;
	}
	
	
}
