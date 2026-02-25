
 
import java.util.Scanner;


public class question_4
{
     public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your string");
    String Z = sc.nextLine();
    
    String A = Z.toUpperCase();
    System.out.println(A);
    
    String B = Z.toLowerCase();
    System.out.println(B);
    
    String titleCase = "";
    boolean nextUpper = true;
    for (int i = 0; i < Z.length(); i++) {
        char ch = Z.charAt(i);
        if (Character.isSpaceChar(ch)) {
        titleCase += ch;
        nextUpper = true;  // Next character should be capital
        } else if (nextUpper) {
        titleCase += Character.toUpperCase(ch);
        nextUpper = false;
        } else {
        titleCase += ch;
        }
    }

    System.out.println("Title Case: " + titleCase);
    }
}
