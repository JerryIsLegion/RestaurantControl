package Restaurant;

import Restaurant.action.ActionType;

import java.util.Scanner;

public class RestaurantMenu {
    public void menu() {

        Scanner scanner = new Scanner(System.in);
        boolean endCycle = false;
        String action = null;
        int actionNumber;

        while (!endCycle) {
            System.out.println("""
                                           
                                           ┌─────────────────┐
                                           │Выберите действие│
                    ┌──────────────────────┘─────────────────└────────────────────────────────┐
                    │ 1. Продать товар                    2. Отчет о проданном товаре         │
                    │-------------------------------------------------------------------------│
                    │ 3. Зарегистрировать работника       4. Получить данные о работнике      │
                    │-------------------------------------------------------------------------│
                    │ 5. Редактирование расписания        6. Закрыть меню                     │
                    │-------------------------------------------------------------------------│
                    └─────────────────────────────────────────────────────────────────────────┘
                    """);
            while (true) {
                actionNumber = scanner.nextInt();
                if (actionNumber <= 0 || actionNumber >= 7) {
                    System.out.println("Такого действия нет");
                } else {
                    break;
                }
            }

            switch (actionNumber) {
                case 1 -> action = "SELL";
                case 2 -> action = "REPORT";
                case 3 -> action = "WRITER";
                case 4 -> action = "READER";
                case 5 -> action = "SCHEDULE";
                case 6 -> endCycle = true;
            }

            if (actionNumber != 6) {
                ActionType actionType = ActionType.valueOf(action);
                actionType.getActionExecutor().execute();
            }
        }
    }
}
