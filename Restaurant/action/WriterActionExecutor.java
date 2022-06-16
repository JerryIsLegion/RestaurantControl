package Restaurant.action;

import java.sql.*;
import java.util.Scanner;

class WriterActionExecutor implements ActionExecutor {
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into workers (name, lastname, age) values(?,?,?)");
            System.out.println("\nВведите имя: ");
            preparedStatement.setString(1, scanner.next());

            System.out.println("Введите фамилию: ");
            preparedStatement.setString(2, scanner.next());

            System.out.println("Введите возраст: ");
            preparedStatement.setInt(3, scanner.nextInt());
            System.out.println();

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
