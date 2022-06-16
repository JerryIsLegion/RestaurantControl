package Restaurant.action;

import Restaurant.action.schedule.ScheduleType;

import java.util.Scanner;

class ScheduleActionExecutor implements ActionExecutor {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean endCycle = false;
        String action = null;
        int actionNumber;

        while (!endCycle) {
            System.out.println("""
                                           
                                           ┌─────────────────┐
                                           │Выберите действие│
                    ┌──────────────────────┘─────────────────└────────────────────────────────┐
                    │ 1. Добавить рабочий день            4. Добавить выходной                │
                    │-------------------------------------------------------------------------│
                    │ 2. Добавить рабочую неделю          5. Добавить неделю выходных         │
                    │-------------------------------------------------------------------------│
                    │ 3. Добавь работника                 6. Удалить работника                │
                    │-------------------------------------------------------------------------│
                    └─────────────────────────────────────────────────────────────────────────┘
                    ┌─────────────────────────────────────────────────────────────────────────┐
                    │ 7. Распечатать расписание           8. Закрыть меню редактора расписания│
                    └─────────────────────────────────────────────────────────────────────────┘
                    """);
            while (true) {
                actionNumber = scanner.nextInt();
                if (actionNumber <= 0 || actionNumber >= 9) {
                    System.out.println("Такого действия нет");
                } else {
                    break;
                }
            }

            switch (actionNumber) {
                case 1 -> action = "N_DAY";
                case 2 -> action = "N_WEEK";
                case 3 -> action = "N_LINE";
                case 4 -> action = "R_DAY";
                case 5 -> action = "R_WEEK";
                case 6 -> action = "R_LINE";
                case 7 -> action = "PRINT";
                case 8 -> {
                    endCycle = true;
                    continue;
                }
            }

            ScheduleType scheduleType = ScheduleType.valueOf(action);
            scheduleType.getScheduleExecutor().execute();
        }
    }
}
