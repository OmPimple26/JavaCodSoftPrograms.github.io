import java.util.*;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks of student obtained in each subject out of 100:\n1.Physics:\n2.Chemistry:\n3.Maths:");

        int marks_Physics=sc.nextInt();
        int marks_Chemistry=sc.nextInt();
        int marks_Maths=sc.nextInt();

        int total_Marks=marks_Physics+marks_Chemistry+marks_Maths;

        float avg_Marks=(float)(total_Marks/3);

        if(avg_Marks>=90){
            System.out.println("A+ grade");
        }else if(avg_Marks>=80 && avg_Marks<90){
            System.out.println("A grade");
        }else if(avg_Marks>=70 && avg_Marks<80){
            System.out.println("B grade");
        }else if(avg_Marks>=60 && avg_Marks<70){
            System.out.println("C grade");
        }else if(avg_Marks>=50 && avg_Marks<60){
            System.out.println("D grade");
        }else if(avg_Marks>=40 && avg_Marks<50){
            System.out.println("E grade");
        }else if(avg_Marks>=35 && avg_Marks<40){
            System.out.println("F grade");
        }else{
            System.out.println("You did not pass the exam.");
        }    

        System.out.println("The total marks obtained by the student are: "+total_Marks+" marks");

        System.out.println("The average percentage obtained by the student is: "+avg_Marks+" %");

    }
}
