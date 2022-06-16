package Restaurant.action.schedule;

import java.sql.*;
import java.util.Scanner;

class SetDayScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            System.out.println("Введите день недели: ");
            PreparedStatement preparedStatement = connection.prepareStatement("update schedule set " + scanner.next() + " = 'Работает' where id = ?");

            System.out.println("Введите id работника: ");
            preparedStatement.setInt(1, scanner.nextInt());
            System.out.println();

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}