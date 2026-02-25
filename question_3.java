 
import java.util.Scanner;


public class question_3
{//q3
      public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.print("Enter index to retrieve character: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index < text.length()) {
            char ch = text.charAt(index);
            System.out.println("Character at index " + index + " is: " + ch);
        } else {
            System.out.println("Invalid index!");
        }

        System.out.print("Enter a character to find: ");
        char searchChar = sc.next().charAt(0);

        int position = text.indexOf(searchChar);

        if (position != -1) {
            System.out.println("First occurrence of '" + searchChar + "' is at index: " + position);
        } else {
            System.out.println("Character not found!");
        }

        sc.nextLine();
        System.out.print("Enter a word to search: ");
        String word = sc.nextLine();
        if (text.contains(word)) {
            int wordIndex = text.indexOf(word);
            System.out.println("Word found at index: " + wordIndex);
        } else {
            System.out.println("Word not found!");
        }
    }

}
