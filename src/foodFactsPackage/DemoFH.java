package foodFactsPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class DemoFH implements Serializable{
	private static final long serialVersionUID = 1;
	public int a;
	public String b;
	
	DemoFH(int a, String b){
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		//searialize a DemoFH object
		DemoFH d1 = new DemoFH(1,"hi");
		DemoFH d2 = new DemoFH(2,"bye");
		ArrayList<DemoFH> list = new ArrayList<DemoFH>();
		list.add(d1);
		list.add(d2);
		FileHandler.writeObjectToFile("test.ser", list);
		
		//deserialize the same DemoFH object
		//DemoFH d3 = (DemoFH)fh.readObjectFromFile("test.ser");
		ArrayList<Object> d = FileHandler.readObjectFromFile("test.ser");
		ArrayList<DemoFH> result = new ArrayList<DemoFH>();
		for (Object o : d){
			result.add((DemoFH)o);
		}
		for (DemoFH dfh : result){
			System.out.printf("Deserialized object d: a = %d, b = %s \n", dfh.a,dfh.b);
		}
		String separator = System.getProperty("line.separator");
		String text = String.format("line1 text %sline2 text %sline3 text %s",separator,separator,separator);
		String filename = "StringTest.txt";
		FileHandler.writeStringToFile(filename,text);
	}
}
