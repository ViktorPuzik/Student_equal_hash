package sample;

import java.util.Scanner;

public class NewStudent {

	public String scanName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		return sc.nextLine();
	}
	public String scanLastName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter last name");
		return sc.nextLine();
	}
	public Gender scanGender() {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("Enter gender m or f");
			String str = sc.nextLine();
			if  (str.equalsIgnoreCase("m")) {return Gender.MALE;}
			if  (str.equalsIgnoreCase("f")) {return Gender.FEMALE;}
		}
	}
	public int scanID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID");
		return sc.nextInt();
	}
	public Student createNewStudent() {
		Student ns = new Student();
		ns.setName(scanName());
		ns.setLastName(scanLastName());
		ns.setGender(scanGender());
		ns.setId(scanID());
		ns.setGroupName(null);
		return ns;
	}
}
