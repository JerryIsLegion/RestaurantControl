package Restaurant.action.schedule;

import java.sql.*;
import java.util.Objects;

class PrintScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute() {
        String[] dbElement;
        String[] days;
        int[] id;
        int counter = 0;
        int totalRow;

        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from schedule");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            // initializing array that will contain the column names
            dbElement = new String[resultSetMetaData.getColumnCount()];

            // printing all the column names from the database
            System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.print("│    " + (dbElement[i - 1] = resultSetMetaData.getColumnName(i)) + "    ");
            }
            System.out.println("│\n└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");

            // writing to variable(totalRow) how many rows in the database and initializing arrays(id, days)
            resultSet = statement.executeQuery("select count(*) as total from schedule");
            resultSet.next();
            id = new int[resultSet.getInt("total")];
            days = new String[resultSet.getInt("total") * resultSetMetaData.getColumnCount() - 1];
            totalRow = resultSet.getInt("total");

            // retrieving data from the database to arrays(id, days)
            for (int i = 0; i < dbElement.length; i++) {
                resultSet = statement.executeQuery("select " + dbElement[i] + " from schedule as counter");
                if (i > 0) {
                    while (resultSet.next()) {
                        days[counter] = resultSet.getString(dbElement[i]);
                        counter++;
                    }
                } else {
                    while (resultSet.next()) {
                        id[counter] = resultSet.getInt("id");
                        counter++;
                    }
                }
                counter = i > 0 ? counter : 0;
            }
            counter = 0;

            // printing all rows which we got from the previous part of code as a data from the database
            for (int i = 0; i < totalRow; i++) {
                counter = i;
                System.out.print("     " + id[i]);
                for (int j = 0; j < resultSetMetaData.getColumnCount() - 1; j++) {
                    if (Objects.equals(days[counter], "Работает")) {
                        System.out.print("        " + days[counter]);
                    } else {
                        System.out.print("     " + days[counter]);
                    }
                    counter += totalRow;
                }
                System.out.println("\n     ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
