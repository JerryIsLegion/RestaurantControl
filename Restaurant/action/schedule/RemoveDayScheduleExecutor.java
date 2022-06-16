package Restaurant.action.schedule;

import java.sql.*;
import java.util.Scanner;

class RemoveDayScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            System.out.println("Введите день недели: ");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE schedule SET " + scanner.next() + " = default WHERE id = ?");

            System.out.println("Введите id работника: ");
            preparedStatement.setInt(1, scanner.nextInt());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
