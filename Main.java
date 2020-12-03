import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

	public static void write(long id, String name) {
		Student s = new Student(id, name);
		Student.serializeToXML(s);
		System.out.println("wrote object to file");
	}

	public static void read() {
		try { 	
			Student s = Student.deserializeFromXML();
			System.out.println(s.toString());
		} catch(IOException e) {}
	}

	public static void main(String args[]) throws IOException {
		//System.out.println(Arrays.toString(args));
		//if(args[0].equals("write")) {
		//	long id = Long.parseLong(args[1]);
		//	write(id, args[2]);
		//} else {
		//	read();
		//}
		List<Student> entries = new ArrayList<Student>();
		entries.add(new Student(1L, "alpha"));
		entries.add(new Student(2L, "beta"));
		entries.add(new Student(3L, "gamma"));
		entries.add(new Student(4L, "pi"));
		createRegistry(entries);
		System.out.println("Success");
	}

	public static void createRegistry(List<Student> entries) throws IOException, FileNotFoundException {
		Registrar R = new Registrar();
		R.setEntries(entries);
		XMLEncoder x = new XMLEncoder(new FileOutputStream("registry.xml"));
		x.writeObject(R);
		x.close();
	}

	public static void openRegistry() throws IOException, FileNotFoundException {

	}
}
