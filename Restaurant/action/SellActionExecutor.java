package Restaurant.action;

import java.sql.*;
import java.util.Scanner;

class SellActionExecutor implements ActionExecutor {
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from soldFood");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for (int i = 2; i <= resultSetMetaData.getColumnCount(); i++) {
                PreparedStatement preparedStatement = connection.prepareStatement("update soldfood set " + resultSetMetaData.getColumnName(i) + " = ?");
                System.out.printf("\nВведите количество проданного товара(%s)\n", resultSetMetaData.getColumnName(i));
                preparedStatement.setInt(1, scanner.nextInt());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
