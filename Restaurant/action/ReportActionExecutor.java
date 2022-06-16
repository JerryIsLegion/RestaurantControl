package Restaurant.action;

import java.sql.*;

class ReportActionExecutor implements ActionExecutor {
    public void execute() {
        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from soldfood where id = 1");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            resultSet.next();

            System.out.println("\nОтчет о проданном товаре:\n");
            for (int i = 2; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.printf("%s продано %d шт.\n", resultSetMetaData.getColumnName(i), resultSet.getInt(resultSetMetaData.getColumnName(i)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
