import java.sql.*;

public class DB {
    private String DRIVER = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://localhost:3306/javalearn";
    private String user = "root";
    private String pwd = "123456";
    private Connection conn = null;
    private Statement statement = null;

    public Statement connectDB() {
        try {
            Class.forName(this.DRIVER);
            this.conn = DriverManager.getConnection(this.url, this.user, this.pwd);
            this.statement = this.conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return this.statement;
    }

    public void disConnectDB() throws SQLException {
        this.statement.close();
    }
}