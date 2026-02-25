 
import java.util.Scanner;


public class question_2
{//q2
     public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
        
        System.out.println("enter first string ");
        String roshan = sc.nextLine();
        String tamang = roshan.trim();
        System.out.println(tamang);
        
        String goley = roshan.substring(0,10);
        System.out.println(goley);
        
        String[] bhanjyang = roshan.split("");
        for(String n : bhanjyang)
        {
            System.out.println(n);
     }
}
}
