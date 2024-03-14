import java.sql.ResultSet;
import java.sql.SQLException;
public class dbModel {
    public DB DB = new DB();

    public void select(String sName) throws SQLException {
        // 判斷查詢的名字有無存在資料庫
        String selectCountTableSQL = "SELECT Count(*) FROM member WHERE name = '" + sName + "'";
        ResultSet selectCountRes = DB.connectDB().executeQuery(selectCountTableSQL);
        while (selectCountRes.next()) {
            // 如果有的話 繼續搜尋使用者資料，若沒有的話 跑ELSE
            if (selectCountRes.getInt(1) > 0) {
                String selectTableSQL = "SELECT * FROM member WHERE name = '" + sName + "'";
                ResultSet selectRes = DB.connectDB().executeQuery(selectTableSQL);
                // 處理使用者資料，並且印出
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
    }

    public void insert(String insName, String insAddress, int insAge) throws SQLException {
        DB.connectDB();
        // 寫入資料庫語法
        String insertTableSQL = "INSERT INTO member VALUES ('" + insName + "', '" + insAddress + "', " + insAge + ")";
        System.out.print(insertTableSQL);
        int insertRes = DB.connectDB().executeUpdate(insertTableSQL);
        if (insertRes == 1) {
            System.out.print("註冊成功");
        } else {
            System.out.print("註冊失敗，請聯絡管理者");
        }
    }

    public void up(String oName, String upName, String upAddress, int upAge) throws SQLException {
        DB.connectDB();
        String updataTableSQL = "UPDATE member SET name='" + upName + "', address='" + upAddress + "', age=" + upAge + " WHERE name='" + oName + "';";
        int updataRes = DB.connectDB().executeUpdate(updataTableSQL);

        if (updataRes == 1) {
            System.out.print("變更成功");
        } else {
            System.out.print("變更失敗，請聯絡管理者");
        }
    }
}
