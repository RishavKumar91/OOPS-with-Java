class Student {
    int marks; 
    String name;
    Student() {
        marks = 0;
        name = "NULL";
    }
    Student(Integer r, String n) {
        marks = r;
        name = n;
    }
    void display() {
        System.out.println(name +" " +marks);
    }
    
}
public class Exp01 {
    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student(98, "Rishav");
        Student s3 = new Student(86,"Mayank");

        s1.display();
        s2.display();
        s3.display();
    }
    
}
