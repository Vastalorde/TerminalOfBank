public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String cardNum = "6228123123"; // номер карты
        int pwd = 888888; // пароль
        boolean flag = true; // объявляем логическую переменную
        double surplus = 1000;// баланс

        // интерфейс
        System.out.println("--------- Добро пожаловать в банкомат ICBC ---------");

        / ** Ограничивает количество логинов ** /
        for (int i = 1; i <= 3; i++) {
            System.out.println("Пожалуйста, вставьте свою банковскую карту:");
            String inputCard = input.next();
            System.out.println("Пожалуйста, введите ваш пароль:");
            int inputPwd = input.nextInt();

            // проверяем аккаунт и пароль
            if (inputCard.equals(cardNum) && inputPwd == pwd) {
                flag = true;
                break;
            } else {
                if (i <= 2) {
                    System.out.println("Извините, пароль неверный, у вас все еще есть" + (3 - i) + "Второй шанс!);
                } else {
                    System.out.println("Извините, ваша карта заблокирована!");
                    break;
                }
                flag = false;
            }
        }
    }
}
