import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Define the number of subjects
        int numSubjects = 5;  // You can change this number based on the number of subjects
        
        // Array to store marks for each subject
        int[] marks = new int[numSubjects];
        
        // Taking input for marks of each subject
        System.out.println("Enter marks obtained in " + numSubjects + " subjects (out of 100):");
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];  // Add the marks to totalMarks
        }
        
        // Calculate the average percentage
        double averagePercentage = (totalMarks * 100.0) / (numSubjects * 100);
        
        // Determine the grade based on the average percentage
        char grade = 'F';  // Default grade is F (fail)
        
        if (averagePercentage >= 90) {
            grade = 'A';  // Excellent grade
        } else if (averagePercentage >= 80) {
            grade = 'B';  // Good grade
        } else if (averagePercentage >= 70) {
            grade = 'C';  // Average grade
        } else if (averagePercentage >= 60) {
            grade = 'D';  // Pass grade
        }
        
        // Display the results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + " %");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
