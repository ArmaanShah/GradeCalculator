
/*
 * GradeCalculator.java
 * Author:  Armaan Shah
 *
 *This program does the following:
 *This code calculates the current letter grade, the current grade, 
 *and the average needed to achieve the desired letter grade (as needed),
 *based on a series of inputs. The user will input their desired letter grade, 
 *the weight of each component of their grade, and the grades they already know. 
 *Based on those inputs, the code will calculate if the user's desired letter grade is possible, 
 *and if it is, it will give an average of what the unknown components must be. 
 *

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Display grading scale
		System.out.println("Grading Scale:");
		System.out.println("A     90 - 100");
		System.out.println("B     80 - 89");
		System.out.println("C     70 - 79");
		System.out.println("D     60 - 69");
		System.out.println("F     below 60");

		// prompts user for desired grade
		System.out.print("What letter grade do you want to achieve for the course?");
		String DesiredLetterGrade = scanner.nextLine().toUpperCase();
		// Ensures desired letter grade is valid
		if (!DesiredLetterGrade.equals("A") && !DesiredLetterGrade.equals("B") && !DesiredLetterGrade.equals("C")
				&& !DesiredLetterGrade.equals("D") && !DesiredLetterGrade.equals("F")) {

			System.out.println("The input is invalid.");
			System.exit(0);

		}

		// Gets weight of all components
		System.out.println("Enter the percentage weight below.");

		System.out.printf("Exam 1:\t\t\t");
		double Exam1Weight = scanner.nextDouble();

		System.out.printf("Exam 2:\t\t\t");
		double Exam2Weight = scanner.nextDouble();

		System.out.printf("Final Exam:\t\t");
		double FinalExamWeight = scanner.nextDouble();

		System.out.printf("Labs:\t\t\t");
		double LabsWeight = scanner.nextDouble();

		System.out.printf("Projects:\t\t");
		double ProjectsWeight = scanner.nextDouble();

		System.out.printf("Participation:\t\t");
		double ParticipationWeight = scanner.nextDouble();

		System.out.printf("Quizzes:\t\t");
		double QuizzesWeight = scanner.nextDouble();

		// stores the total weight

		double TotalWeight = Exam1Weight + Exam2Weight + FinalExamWeight + LabsWeight + ProjectsWeight
				+ ParticipationWeight + QuizzesWeight;

		// Ensures total weight equals 100
		if (TotalWeight == 100) {

		} else {
			System.out.println("Weights don't add up to 100, program exiting...");
			System.exit(0);

		}

		// Initializing Exam with value out of range

		double Exam1Score = -1;
		double Exam2Score = -1;
		double FinalExamScore = -1;

		// Initializes known scores and weights
		double CurrentTotal = 0;
		double KnownWeight = 0;

		// retrieving component scores

		// Exam 1
		System.out.print("Do you know your exam 1 score?");
		scanner.nextLine();
		String Exam1Answer = scanner.nextLine().toLowerCase();
		if (Exam1Answer.equals("y") || Exam1Answer.equals("yes")) {
			System.out.print("Score received on exam 1:");
			Exam1Score = scanner.nextDouble();
			CurrentTotal += Exam1Weight * Exam1Score;
			KnownWeight += Exam1Weight;
		}

		// Exam 2
		if (Exam1Score >= 0) {

			System.out.print("Do you know your exam 2 score?");

			String Exam2Answer = scanner.next().toLowerCase();
			if (Exam2Answer.equals("y") || Exam2Answer.equals("yes")) {
				System.out.print("Score received on exam 2:");
				Exam2Score = scanner.nextDouble();
				CurrentTotal += Exam2Weight * Exam2Score;
				KnownWeight += Exam2Weight;
			}
		}

		// Final Exam
		if (Exam2Score >= 0) {
			System.out.print("Do you know your final exam score?");

			String FinalExamAnswer = scanner.next().toLowerCase();

			if (FinalExamAnswer.equals("y") || FinalExamAnswer.equals("yes")) {
				System.out.print("Score received on final exam:");
				FinalExamScore = scanner.nextDouble();
				CurrentTotal += FinalExamWeight * FinalExamScore;
				KnownWeight += FinalExamWeight;

			}
		}

		// Labs
		System.out.print("Do you know your lab average?");
		String LabsAnswer = scanner.next().toLowerCase();

		if (LabsAnswer.equals("y") || LabsAnswer.equals("yes")) {
			System.out.print("Average lab grade:");
			double LabScore = scanner.nextDouble();
			CurrentTotal += LabsWeight * LabScore;
			KnownWeight += LabsWeight;

		}

		// Projects
		System.out.print("Do you know your project average?");

		String ProjectsAnswer = scanner.next().toLowerCase();
		if (ProjectsAnswer.equals("y") || ProjectsAnswer.equals("yes")) {
			System.out.print("Average project grade:");
			double ProjectScore = scanner.nextDouble();
			CurrentTotal += ProjectsWeight * ProjectScore;
			KnownWeight += ProjectsWeight;

		}

		// Participation
		System.out.print("Do you know your participation average?");

		String ParticipationAnswer = scanner.next().toLowerCase();
		if (ParticipationAnswer.equals("y") || ParticipationAnswer.equals("yes")) {
			System.out.print("Average participation grade:");
			double ParticipationScore = scanner.nextDouble();
			CurrentTotal += ParticipationWeight * ParticipationScore;
			KnownWeight += ParticipationWeight;

		}

		// Quizzes
		System.out.print("Do you know your quiz average?");

		String QuizzesAnswer = scanner.next().toLowerCase();
		if (QuizzesAnswer.equals("y") || QuizzesAnswer.equals("yes")) {
			System.out.print("Average quiz grade:");
			double QuizScore = scanner.nextDouble();
			CurrentTotal += QuizzesWeight * QuizScore;
			KnownWeight += QuizzesWeight;

		}

		// Calculate and display current grade
		double CurrentGrade = CurrentTotal / KnownWeight;
		System.out.printf("Current grade score:%.2f%n", CurrentGrade);

		// Determine letter grade based on current grade
		String CurrentLetterGrade = "";
		if (CurrentGrade >= 90)
			CurrentLetterGrade = "A";
		else if (CurrentGrade >= 80 && CurrentGrade < 90)
			CurrentLetterGrade = "B";
		else if (CurrentGrade >= 70 && CurrentGrade < 80)
			CurrentLetterGrade = "C";
		else if (CurrentGrade >= 60 && CurrentGrade < 70)
			CurrentLetterGrade = "D";
		else if (CurrentGrade < 60) {
			CurrentLetterGrade = "F";
		}
		System.out.println("Your current letter grade:" + CurrentLetterGrade);

		// sets finalOverallScore to minimum value in range
		double FinalOverallScore = 0;

		if ("A".equals(DesiredLetterGrade)) {
			FinalOverallScore = 90;
		} else if ("B".equals(DesiredLetterGrade)) {
			FinalOverallScore = 80;
		} else if ("C".equals(DesiredLetterGrade)) {
			FinalOverallScore = 70;
		} else if ("D".equals(DesiredLetterGrade)) {
			FinalOverallScore = 60;
		}
		//calculates the average needed to get the desired letter grade 

		double avgToFinalLetterGrade = (100 * FinalOverallScore - CurrentTotal) / (100 - KnownWeight);
		// Determines if the user's desired score is attainable
		if (CurrentLetterGrade.equals(DesiredLetterGrade)) {
			// Congratulates user if they already achieved the desired grade
			System.out.println("Congratulations! You received the " + DesiredLetterGrade + " that you wanted!");
		} else if (avgToFinalLetterGrade <= 0) {
			// If no more points are needed to achieve the grade
			System.out.printf("You will receive at least a grade of %s.%n", DesiredLetterGrade);
		} else if (avgToFinalLetterGrade > 100) {
			// If the required average is greater than 100, it's not possible to get the
			// desired grade
			System.out.println("Unfortunately, a grade of " + DesiredLetterGrade + " is not possible.");
		} else {
			// If the desired grade is still possible, display the required average
			System.out.printf(
					"In order to receive a grade of %s,%n" + "you need to score an average greater than%n"
							+ "or equal to %.2f in the rest of the grade items.%n",
					DesiredLetterGrade, avgToFinalLetterGrade);
		}

	}// main method

}// class
