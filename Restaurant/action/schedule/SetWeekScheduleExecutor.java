package Restaurant.action.schedule;

import java.sql.*;
import java.util.Scanner;

class SetWeekScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id работника: ");
        int workerId = scanner.nextInt();

        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from schedule");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for (int i = 2; i <= resultSetMetaData.getColumnCount() - 2; i++) {
                PreparedStatement preparedStatement = connection.prepareStatement("update schedule set " + resultSetMetaData.getColumnName(i) + " = 'Работает' where id = ?");
                preparedStatement.setInt(1, workerId);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
