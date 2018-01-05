package HackerRank;

import java.util.Scanner;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;

	/*
	 * //default constructor Person(){ }
	 */
	// Constructor

	Person(String firstName, String lastName, int identification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

	// Print person data
	public void printPerson() {
		System.out.println("Name: " + lastName + ", " + firstName + "\nID: "
				+ idNumber);
	}

}

class Student extends Person {
	private int[] testScores;

	/*
	 * Class Constructor
	 * 
	 * @param firstName - A string denoting the Person's first name.
	 * 
	 * @param lastName - A string denoting the Person's last name.
	 * 
	 * @param id - An integer denoting the Person's ID number.
	 * 
	 * @param scores - An array of integers denoting the Person's test scores.
	 */
	// Write your constructor here

	/* Concept
	 *  * Note: If a superclass does not have a default constructor, any
	 * subclasses extending it must make an explicit(i.e use super->JVM takes
	 * care) call to one of the superclass' parameterized constructors.
	 */
	Student(String firstName, String lastName, int identification,
			int[] testScores) {
		super(firstName, lastName, identification);

		this.testScores = testScores;
	}

	// if there had been default person constructor then below works which is
	// called implicit call->i.e programmer directly links. example is given below:
	/*
	 * Student(String firstName, String lastName, int identification, int[]
	 * testScores) { this.firstName = firstName; this.lastName = lastName;
	 * this.idNumber = identification; this.testScores=testScores; }
	 */

	/*
	 * Method Name: calculate
	 * 
	 * @return A character denoting the grade.
	 */
	// Write your method here
	public String calculate() {
		int sum = 0;
		float avg = 0;
		String grade = new String();
		for (int i = 0; i < testScores.length; i++) {
			sum += testScores[i];
		}
		avg = sum / testScores.length;

		if (avg >= 90 && avg <= 100) {
			grade = "O";
		} else if (avg >= 80 && avg < 90) {
			grade = "E";

		} else if (avg >= 70 && avg < 80) {
			grade = "A";

		} else if (avg >= 55 && avg < 70) {
			grade = "P";

		} else if (avg >= 40 && avg < 55) {
			grade = "D";
		}

		else if (avg < 40) {
			grade = "T";
		}
		return grade;

	}
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}
