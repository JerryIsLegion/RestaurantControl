package Restaurant.action.schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveLineScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            System.out.println("\nВведите номер строки которую хотите удалить: ");
            connection.prepareStatement("delete from schedule where id = " + scanner.nextInt()).execute();
            connection.prepareStatement("alter table schedule auto_increment = 1001").execute();
            System.out.println("\nСтрока удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
