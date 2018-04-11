package foodFactsPackage;

import java.io.Serializable;

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
		FileHandler fh = new FileHandler();
		fh.writeObjectToFile("test.ser", d1);
		
		//deserialize the same DemoFH object
		DemoFH d3 = (DemoFH)fh.readObjectFromFile("test.ser");
		System.out.printf("Deserialized object d3: a = %d, b = %s \n", d3.a,d3.b);
		
	}
}
