import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        String DRIVER = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://localhost:3306/saven";
        String user = "root";
        String pwd = "123456";
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, user, pwd);
            while (true) {
                System.out.print("請輸入您要操作的功能：" +
                        "輸入1為查詢會員資料，" +
                        "輸入2為註冊會員，" +
                        "輸入3為變更會員資料，" +
                        "跳出請隨意輸入其他數字。"
                );
                Scanner searchAction = new Scanner(System.in);
                String action = searchAction.next();
                statement = conn.createStatement();

                switch (action) {
                    case "1":
                        System.out.print("請輸入您的大名：");
                        Scanner selectName = new Scanner(System.in);
                        String sName = selectName.next();
                        String selectCountTableSQL = "SELECT Count(*) FROM member WHERE name = '" + sName + "'";
                        ResultSet selectCountRes = statement.executeQuery(selectCountTableSQL);
                        while (selectCountRes.next()) {
                            if (selectCountRes.getInt(1) > 0) {
                                String selectTableSQL = "SELECT * FROM member WHERE name = '" + sName + "'";
                                ResultSet selectRes = statement.executeQuery(selectTableSQL);

                                while (selectRes.next()) {
                                    String name = selectRes.getString("name");
                                    String address = selectRes.getString("address");
                                    String age = selectRes.getString("age");
                                    System.out.println("姓名 : " + name + ", 地址：" + address + ", 年齡：" + age);
                                };
                            } else {
                                System.out.print("此姓名還沒註冊 ！");
                            }
                        }
                        break;
                    case "2":
                        System.out.print("請輸入您的大名：");
                        Scanner insertName = new Scanner(System.in);
                        String insName = insertName.next();
                        System.out.print("請輸入您的地址：");
                        Scanner insertAddress = new Scanner(System.in);
                        String insAddress = insertAddress.next();
                        System.out.print("請輸入您的年齡：");
                        Scanner insertAge = new Scanner(System.in);
                        int insAge = insertAge.nextInt();
                        String insertTableSQL = "INSERT INTO member VALUES ('" + insName + "', '" + insAddress + "', " + insAge + ")";
                        System.out.print(insertTableSQL);
                        int insertRes = statement.executeUpdate(insertTableSQL);
                        if (insertRes == 1) {
                            System.out.print("註冊成功");
                        }
                        break;
                    case "3":
                        System.out.print("請輸入您的之前的大名：");
                        Scanner oldName = new Scanner(System.in);
                        String oName = oldName.next();
                        System.out.print("請輸入您的新大名：");
                        Scanner updataName = new Scanner(System.in);
                        String upName = updataName.next();
                        System.out.print("請輸入您的新地址：");
                        Scanner updataAddress = new Scanner(System.in);
                        String upAddress = updataAddress.next();
                        System.out.print("請輸入您的最新的年齡：");
                        Scanner updataAge = new Scanner(System.in);
                        String upAge = updataAge.next();
                        String updataTableSQL = "UPDATE member SET name='" + upName + "', address='" + upAddress + "', age=" + upAge + " WHERE name='" + oName + "';";
                        int updataRes = statement.executeUpdate(updataTableSQL);
                        if (updataRes == 1) {
                            System.out.print("變更成功");
                        }
                        break;
                    default:
                        System.out.print("not action");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }
    }

//    public static boolean selectDB()
//    {
//
//    }
//
//    public static boolean insertDB()
//    {
//
//    }
//
//    public static boolean updataDB()
//    {
//
//    }
};