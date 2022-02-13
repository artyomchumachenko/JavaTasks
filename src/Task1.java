import java.util.Scanner;

public class Task1 {
    public static int weightWorkpiece;
    public static int weightCoin;
    public static int weightResidue;
    public static int weightResidue1;
    public static int totalCoins;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение массы серебра в граммах");
        weightResidue = scanner.nextInt();
        System.out.println("Введите значение массы заготовки в граммах");
        weightWorkpiece = scanner.nextInt();
        System.out.println("Введите значение массы монеты в граммах");
        weightCoin = scanner.nextInt();

        calculationOfNumberOfCoins();
    }

    public static void calculationOfNumberOfCoins() {
        if (weightWorkpiece > weightCoin) {
            while (weightResidue > weightWorkpiece) {
                weightResidue = weightResidue - weightWorkpiece;
                weightResidue1 = weightWorkpiece - weightCoin;
                totalCoins = totalCoins + 1;
                weightResidue = weightResidue + weightResidue1;
            }
            totalCoins = totalCoins + 1;

        } else System.out.println("Недостаточно серебра");

        System.out.println("Количество полученых монет - " + totalCoins);
    }

}