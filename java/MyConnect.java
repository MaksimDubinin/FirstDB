import java.sql.*;
public class MyConnect {
    private final String url;
    private final String user;
    private final String password;

    public MyConnect() {
        this.url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        this.user = "postgres";
        this.password = "root";
    }

    public String[][] allSelect(String select) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found.");
            System.out.println(e.getMessage());
            return new String[0][0];
        }

        final int row = 4;
        final int col = 3;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
        ) {
            ResultSet rs = statement.executeQuery(select);
            String[][] object = new String[row][col];

            if (rs.next()) {
                for (int i = 1 ; i <= row; ++i) {
                    for (int j = 0; j < col; ++j) {
                        object[i - 1][j] = rs.getString(j + 1);
                    }
                    rs.next();
                }
            }

            return object;
        } catch (SQLException e) {
            System.out.println("Connection failed");
            System.err.println(e.getMessage());
            return new String[0][0];
        }
    }
}
