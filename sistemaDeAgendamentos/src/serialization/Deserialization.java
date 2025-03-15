package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialization {
	public Deserialization() {
	}
	
	public static Object deserialize(String path) throws Exception, ClassNotFoundException {
		FileInputStream inFile = new FileInputStream(path);
		ObjectInputStream d = new ObjectInputStream(inFile);
		Object o = d.readObject();
		d.close();
		return o;
    } 
}
