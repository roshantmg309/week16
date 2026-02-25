 
import java.util.Scanner;



public class question_7
{//q7
    public static boolean isValidPhone(String phone) {
        return phone.matches("^(98|97)[0-9]{8}$");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        if (isValidPhone(phone)) {
            System.out.println("Valid Nepali mobile number");
        } else {
            System.out.println("Invalid Nepali mobile number");
        }
    }
}
