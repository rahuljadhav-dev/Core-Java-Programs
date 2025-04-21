package logical;

import java.util.Scanner;

public class MarkingSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] marks = new int[5];
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("\n=== Menu ===");
			System.out.println("1. Enter the marks");
			System.out.println("2. View total and percentage");
			System.out.println("3. Check result");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				for (int i = 0; i < marks.length; i++) {
					while (true) {
						System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");
						int input = scanner.nextInt();
						if (input >= 0 && input <= 100) {
							marks[i] = input;
							break;
						} else {
							System.out.println("Invalid marks. Please enter between 0 and 100.");
						}
					}
				}
				break;

			case 2:
				int totalMarks = 0;
				for (int mark : marks) {
					totalMarks += mark;
				}
				int percentage = totalMarks / marks.length;
				System.out.println("Total Marks: " + totalMarks);
				System.out.println("Percentage: " + percentage + "%");
				break;

			case 3:
				int failCount = 0;
				for (int mark : marks) {
					if (mark < 35) {
						failCount++;
					}
				}

				if (failCount > 0) {
					System.out.println("You failed in " + failCount + " subject(s).");
				} else {
					System.out.println("Congratulations! You passed the examination.");
				}
				break;

			case 4:
				System.out.println("Thanks for using the application.");
				isRunning = false;
				break;

			default:
				System.out.println("Invalid option. Please choose between 1 and 4.");
				break;
			}
		}

		scanner.close();
	}
}
