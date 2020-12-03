import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class Registrar { 

	private List<Student> entries = new ArrayList<Student>();

	public Registrar() {
	}

	public void setEntries(List<Student> L) {
		entries = L;
	}

	public List<Student> getEntries() {
		return entries;
	}

	public void addEntry(Student s) {
		entries.add(s);
	}

	public String toString() {
		String s = "";
		Iterator<Student> it = entries.listIterator();
		while(it.hasNext()) {
			Student st = it.next();
			s += "Student: "+st.getId()+", "+st.getName()+"\n";
		}
		return s;
	}
}
