package Restaurant.action;

import Restaurant.data.Worker;

import java.sql.*;
import java.util.Scanner;

class ReaderActionExecutor implements ActionExecutor {
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            System.out.println("\nВведите номер работника:");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from workers where id = " + scanner.nextInt());
            resultSet.next();

            String workerName = resultSet.getString("name");
            String workerLastName = resultSet.getString("lastname");
            int workerAge = resultSet.getInt("age");

            Worker worker = new Worker(workerName, workerLastName, workerAge);
            System.out.printf("\nИмя: %s\nФамилия: %s\nВозраст: %d\n\n",
                    worker.getName(),
                    worker.getLastName(),
                    worker.getAge());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
