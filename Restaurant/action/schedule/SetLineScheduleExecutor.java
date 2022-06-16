package Restaurant.action.schedule;

import java.sql.*;

class SetLineScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute() {
        try {
            String host = "jdbc:mysql://localhost:3306/restaurant";
            String uName = "root";
            String uPass = "";
            Connection connection = DriverManager.getConnection(host, uName, uPass);

            connection.prepareStatement("insert into schedule(monday) values(default)").execute();
            System.out.println("\nСтрока добавлена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
