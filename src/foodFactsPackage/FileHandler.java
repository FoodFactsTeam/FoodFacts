package foodFactsPackage;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;

/*
 * FileHandler class currently exports a generic object of any type specified
 * to a file called "test.ser" using the writeObjectToString method, and reads
 * it back in using the readObjectFromFile method. Demonstratin of the funnctionality
 * is in the DemoFH main method. Later I will expand this to save an array ingredient and 
 * recipe classes
 */
public class FileHandler {
	
	FileHandler(){
		//constructor is empty b/c all methods are static
	}
	
	/*
	 * writeObjecttoFile(String,<V> or ArrayList<V>) is a static method.
	 * 
	 * @param filename: specify the file name as a string e.g. "Ingredients.ser"
	 * @param obj or objArray: specify the object or ArrayList of objects to write to file
	 */
	public static <V> void writeObjectToFile(String filename, V obj){
		ArrayList<V> objArray = new ArrayList<V>();
		objArray.add(obj);
		writeObjectToFile(filename,objArray);
	}
	
	public static <V> void writeObjectToFile(String filename, ArrayList<V> objArray){
		try (ObjectOutputStream objectOS = new ObjectOutputStream(new FileOutputStream(filename))) {
			objectOS.writeInt(objArray.size());
			for (Object o : objArray){
				objectOS.writeObject(o);
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * readObjectFromFile(String) reads all of objects from the file and returns them as an ArrayLIist of objects
	 * 
	 * After the arraylist of objects is returned, the user must create a second arraylist and cast them to the actual class type
	 */
	public static ArrayList<Object> readObjectFromFile(String filename){
		ArrayList<Object> result = new ArrayList<Object>();
		try(ObjectInputStream objectIS = new ObjectInputStream(new FileInputStream(filename))) {
			int numObjects = objectIS.readInt();
			for (int i = 0; i < numObjects; i++){
				result.add(objectIS.readObject());
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	/*
	 * writeStringtoFile(String,String) creates a file named filename and writes text to it
	 * 
	 * use the following instead of \n to designate new lines in string - this is platform independent
	 * String separator = System.getProperty("line.separator"); 
	 */
	public static void writeStringToFile(String filename, String text){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
			bw.write(text);
		}
		catch (Exception ex){
			
		}
	}
}
