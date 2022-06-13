package sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {
	private String groupName;
	private Student[] studens = new Student[10];
	public Group(String groupName, Student[] studens) {
		super();
		this.groupName = groupName;
		this.studens = studens;
	}
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Student[] getStudens() {
		return studens;
	}
	public void setStudens(Student[] studens) {
		this.studens = studens;
	}
	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < studens.length; i++) {
			if ((studens[i] == null)||(studens[i].getId() == -1)) {
				student.setGroupName(this.groupName);
				studens[i] = student;
				return;
			}
		} throw new GroupOverflowException(student.getLastName() + " не добавлен. Группа "
			+ student.getGroupName() + " заполнена");
	}
	public Student searchStunentByLastName (String lastName) throws StudentNotFoundException {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null && studens[i].getLastName().equals(lastName)) {
				return studens[i];
			}
		} throw new StudentNotFoundException("Student " + lastName + " not found");
		
	}
	public boolean removeStudentByID(int id) {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null && studens[i].getId() == id) {
				studens[i]= null;
				return true;
			}
		}
		return false;
	}
	public void sortStudentsByLastName() {
		
		Arrays.sort(studens, Comparator.nullsLast(new SortLastNameComparator()));
	}
	
	public Boolean equalStudentsInGroup() {
		for (int i = 0; i < studens.length; i++) {
			for (int r = i+1; i < studens.length; i++) {
				if(studens[i].equals(studens[r])) {return true;}
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(studens);
		result = prime * result + Objects.hash(groupName);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(studens, other.studens);
	}
	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", studens=" + Arrays.toString(studens) + "]";
	}
	
}
