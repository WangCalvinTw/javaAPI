import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private String DRIVER = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://localhost:3306/javalearn";
    private String user = "";
    private String pwd = "";
    private Connection conn = null;

    public Statement statement = null;

    public void connectDB() {
        try {
            Class.forName(this.DRIVER);
            this.conn = DriverManager.getConnection(this.url, this.user, this.pwd);
            this.statement = this.conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}