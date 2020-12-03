import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.IOException;

public class Student {

	private long id;
	private String name;

	public Student() {
		id = 0L;
		name = "";
	}
	
	public Student(long id, String name) {
		this.id = id;
		this.name = name;
	}	

	@Override
	public String toString() {
		return id + " -> " + name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	static void serializeToXML(Student s) {
		FileOutputStream fout = null;
		XMLEncoder encoder = null;
		try {
			fout = new FileOutputStream("student.xml");
			encoder = new XMLEncoder(fout);
			encoder.writeObject(s);
			if(encoder != null) {
				encoder.close();
			}
			if(fout != null) {
				fout.close();
			}
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}

	static Student deserializeFromXML() throws IOException {
		FileInputStream fin = new FileInputStream("student.xml");
		XMLDecoder dec = new XMLDecoder(fin);
		Student s = (Student) dec.readObject();
		dec.close();
		fin.close();
		return s;
	}	

}
