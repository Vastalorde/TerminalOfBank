import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String cardNum = "6228123123";
        int pwd = 77777;
        boolean flag = true;
        double balance = 10000;

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
        if(flag){
            char a = 'y';
            while (a =='y'){
                System.out.println("Please select a function: 1. Withdrawal 2. Deposit 3. Check balance 4. Money transaction 5. Exit");
                int choise = input.nextInt();
                switch (choise){
                    case 1:
                        System.out.println("---->Withdrawals");
                        System.out.println("Please enter the withdrawal amount:");
                        double get_money = input.nextDouble();
                        if(get_money > 0){
                            if (get_money <= balance){
                                if (get_money % 100 == 0){
                                    System.out.println("Please take your banknote! Balance:" + " " +(balance-get_money) +" "+ "UAH" );
                                }
                            }else {
                                System.out.println("Sorry, the balance is not enough!");
                            }
                        }else{
                            System.out.println("Please enter the correct amount:");
                            get_money = input.nextDouble();
                            System.out.println("Please take your banknote! Balance:" + " " +(balance-get_money) +" "+ "UAH" );
                        }
                        break;
                    case 2:
                        System.out.println("---->Deposit");
                        System.out.println("Please arrange the banknotes and place them in the deposit port:");
                        double save_money = input.nextDouble();
                        if (save_money > 0 && save_money <= 5000){
                            if (save_money % 100 == 0){
                                balance += save_money;
                                System.out.println("Deposit successful! Balance: " + " " + balance + " " + "UAH");
                            }else{
                                double back_money = save_money % 100;
                                balance = save_money + balance - back_money;
                                System.out.println("Deposit successful! Balance: " + " " + balance + " " + "UAH");
                                System.out.println("Please pick up your change: " + " " + back_money + " " + "UAH");
                            }
                        }else if(save_money > 5000){
                            System.out.println("Deposit up to 5000 UAH at a time, please deposit in batches!");
                            save_money = input.nextDouble();
                            balance += save_money;
                            System.out.println("Deposit successful! Balance: " + " " + balance + " " + "UAH");
                        }
                        break;
                    case 3:
                        System.out.println("---->Check balance");
                        System.out.println("Balance on your card:" + " " + balance + " " + "UAH");
                        break;
                    case 4:
                        System.out.println("---->Money transaction");
                        System.out.println("Please enter the recipient's card number:");
                        String cardNum2 = input.next();
                        System.out.println("Please enter the transaction amount:");
                        double transfer = input.nextDouble();
                        if (transfer > 0){
                            if (transfer <= balance){
                                balance -= transfer;
                                System.out.println("---->Transaction info");
                                System.out.println("---->Recipient's card number:" + " " + cardNum2);
                                System.out.println("---->Transaction amount:" + " " + transfer);
                                System.out.println("Transaction success! Your Balance: " + " " + (balance) + " " + " UAH");
                            }else {
                                System.out.println("Sorry, please make sure you have enough funds on your card!");
                            }
                        }else{
                            System.out.println("Transaction failed! Please enter the correct amount");
                        }
                        break;
                    case 5:
                        System.out.println("Thanks for your use!");
                        return;
                    default:
                        System.out.println("Sorry, the function you selected is incorrect!");
                        break;
                }
                System.out.println("Continue? Yes/No");
                a = input.next().charAt(0);
            }
            System.out.println("Thanks for your use!");

        }

    }
}
