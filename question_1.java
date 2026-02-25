
import java.util.Scanner;

public class question_1
{ //q1
    public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("enter first string ");
        String A = sc.nextLine();
        System.out.println("enter second string");
        String B = sc.nextLine();
        String C = A.concat(B);
        System.out.println(C);
        System.out.println("Enter third string");
        String D = sc.nextLine();
        
        System.out.println(C.equals(D));
        
    }
}
