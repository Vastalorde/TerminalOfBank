import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String cardNum = "6228123123";
        int pwd = 888888;
        boolean flag = true;
        double surplus = 1000;

        System.out.println("--------- Welcome to ICBC ATM ---------");


        for (int i = 1; i <= 3; i++) {
            System.out.println("Please insert your bank card:");
            String inputCard = input.next();
            System.out.println("Please enter your password:");
            int inputPwd = input.nextInt();


            if (inputCard.equals(cardNum) && inputPwd == pwd) {
                flag = true;
                break;
            } else {
                if (i <= 2) {
                    System.out.println("Sorry, the password is wrong, you still have " + " " + (3 - i)+ " " + "Attempts");
                } else {
                    System.out.println("Sorry, your card has been blocked!");
                    break;
                }
                flag = false;
            }
        }
    }
}
