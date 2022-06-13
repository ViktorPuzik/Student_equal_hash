package sample;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, GroupOverflowException, FileNotFound {
		// TODO Auto-generated method stub
		
		Group group1 = new Group();
		group1.setGroupName("Group 1");
		NewStudent ns = new NewStudent();
		

		Student student1 = new Student("Petro", "Ivanov", Gender.MALE, 1, null);
		Student student2 = new Student("Inan", "Petrov", Gender.MALE, 2, null);
		Student student3 = new Student("Kolya", "Sidorov", Gender.MALE, 3, null);
		Student student4 = new Student("Petro", "Ivanov", Gender.MALE, 1, null);
		Student student5 = new Student("Lena", "Shevchenko", Gender.FEMALE, 5, null);
		Student student6 = new Student("Denis", "Galatenko", Gender.MALE, 6, null);
		Student student7 = new Student("Viktor", "Denisuk", Gender.MALE, 7, null);
		Student student8 = new Student("Alina", "Kalugina", Gender.FEMALE, 8, null);
		Student student9 = new Student("Polina", "Gordienko", Gender.FEMALE, 9, null);
		Student student10 = new Student("Grisha", "Dec", Gender.MALE, 10, null);
		Student student11 = new Student("Galina", "Vovk", Gender.MALE, 11,null);

		try {
			group1.addStudent(ns.createNewStudent());
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
			group1.addStudent(student8);
			group1.addStudent(student9);
			group1.addStudent(student10);
			group1.addStudent(student11);
		} catch (GroupOverflowException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(group1.equalStudentsInGroup());
		
		group1.sortStudentsByLastName();
		Student st = new Student(); 
		try {
			
		st =group1.searchStunentByLastName("Sorokin");
		System.out.println(st.toString());
		} catch (StudentNotFoundException e) {
			System.err.println(e.getMessage());
		}
		try {
			
		st =group1.searchStunentByLastName("Ivanov");
		System.out.println(st.toString());
		} catch (StudentNotFoundException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(group1.removeStudentByID(1));
		System.out.println(group1.removeStudentByID(111));
		System.out.println(group1.toString());
		System.out.println("---------------------------------------------");
		GroupFileStorage.saveGroupToCSV(group1, "D:\\copy");
		System.out.println("---------------------------------------------");
		System.out.println(GroupFileStorage.loadGroupFromCSV(new File("D:\\copy\\Group 1.csv")).toString());
		System.out.println("---------------------------------------------");
		try {
		System.out.println(GroupFileStorage.findFileByGroupName("Group", new File("D:\\copy")).getAbsolutePath());
		} catch (FileNotFound e) {
			System.err.println(e.getMessage());
			// TODO: handle exception
		}
		System.out.println("---------------------------------------------");
		
	} 
	
	/*catch (Exception e) {
		e.printStackTrace();
	*/
	
}
