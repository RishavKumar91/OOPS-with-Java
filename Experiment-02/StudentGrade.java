import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks (0 to 100): ");
            int marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }

            String grade;

            if (marks >= 90) {
                grade = "A";
            } 
            
            else if (marks >= 75) 
            {
                grade = "B";
            } 
            
            else if (marks >= 60) 
            {
                grade = "C";
            } 
            
            else if (marks >= 40) 
            {
                grade = "D";
            } 
            
            else 
            {
                grade = "Fail";
            }

            System.out.println("Student Name: " + name);
            System.out.println("Marks Entered: " + marks);
            System.out.println("Grade Obtained: " + grade);

        } 
        catch(IllegalArgumentException e){
            System.out.println("Invalid input - Marks must be between 0 and 100.");
        }

        catch(Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } 
        finally {
            sc.close();
        }
    }
}
