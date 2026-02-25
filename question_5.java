
 
import java.util.Scanner;


public class question_5
{//q5
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial string: ");
        String first = sc.nextLine();

        StringBuilder sb = new StringBuilder(first);

        System.out.print("Enter second string: ");
        String second = sc.nextLine();

        sb.append(second);

        sb.append(100);

        sb.append('@');

        System.out.println("Final Modified String: " + sb);
    }
}
