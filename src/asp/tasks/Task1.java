package asp.tasks;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDenominations;
        int[] denominationsOfBanknotes;
        int amountRequired;

        System.out.println("Введите количество номиналов: ");
        numberOfDenominations = scanner.nextInt();
        denominationsOfBanknotes = new int[numberOfDenominations];
        for (int i = 0; i < numberOfDenominations; i++) {
            System.out.print((i+1) + " номинал = ");
            denominationsOfBanknotes[i] = scanner.nextInt();
        }
        System.out.println("Введите требуемую сумму: ");
        amountRequired = scanner.nextInt();

        StringBuilder result = new StringBuilder();
        for (int i = numberOfDenominations - 1; i >= 0; i--) {
            int k = amountRequired / denominationsOfBanknotes[i];
            for (int j = 0; j < k; j++) {
                result.insert(0, " ").insert(0, denominationsOfBanknotes[i]);
            }
            amountRequired = amountRequired - (denominationsOfBanknotes[i] * k);
        }

        System.out.println("Результат\n" + result);
    }
}
