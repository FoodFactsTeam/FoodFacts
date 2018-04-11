package foodFactsPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * FileHandler class currently exports a generic object of any type specified
 * to a file called "test.ser" using the writeObjectToString method, and reads
 * it back in using the readObjectFromFile method. Demonstratin of the funnctionality
 * is in the DemoFH main method. Later I will expand this to save an array ingredient and 
 * recipe classes
 */
public class FileHandler {
	ObjectInputStream objectIS;
	ObjectOutputStream objectOS;
	FileInputStream fileIS;
	FileOutputStream fileOS;
	
	
	FileHandler(){
		
	}
	
	public <V> void writeObjectToFile(String filename, V obj){
		try {
			fileOS = new FileOutputStream(filename);
			objectOS = new ObjectOutputStream(fileOS);
			objectOS.writeObject(obj);
			objectOS.close();
			fileOS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <V> Object readObjectFromFile(String filename){
		Object obj = null;
		try {
			fileIS = new FileInputStream(filename);
			objectIS = new ObjectInputStream(fileIS);
			obj = objectIS.readObject();
			objectIS.close();
			fileIS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
