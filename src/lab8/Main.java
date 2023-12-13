package lab8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StorageCamera camera = new StorageCamera(10, 15);
        String userInput = "";

        while (!userInput.equals("stop")) {
            try {
                System.out.println("Введіть деталі (ряд  колонка  предмет) або введіть 'stop' для завершення:");
                userInput = scanner.nextLine();

                if (userInput.equals("stop")) {
                    break;
                }

                String[] details = userInput.split(" ");
                if (details.length != 3) {
                    System.out.println("Неправильний формат вводу. Введіть у форматі 'ряд колонка предмет'.");
                    continue;
                }

                int row = Integer.parseInt(details[0]);
                int column = Integer.parseInt(details[1]);
                String item = details[2];

                camera.storeItem(row, column, item);
            } catch (StorageCellException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Неправильний формат.");
            }
        }
        scanner.close();
    }
}
