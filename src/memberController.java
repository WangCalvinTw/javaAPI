import java.util.Scanner;


public class memberController {
    public void memberService() {
        dbModel getDB = new dbModel();

        try {
            while (true) {
                System.out.print("請輸入您要操作的功能：" +
                        "輸入1為查詢會員資料，" +
                        "輸入2為註冊會員，" +
                        "輸入3為變更會員資料，" +
                        "跳出請隨意輸入其他數字。"
                );

                // 使用者輸入
                Scanner searchAction = new Scanner(System.in);
                String action = searchAction.next();

                switch (action) {
                    case "1":
                        System.out.print("請輸入您的大名：");
                        Scanner selectName = new Scanner(System.in);
                        String sName = selectName.next();
                        getDB.select(sName);
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
                        getDB.insert(insName, insAddress, insAge);
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
                        int upAge = updataAge.nextInt();
                        getDB.up(oName, upName, upAddress, upAge);
                        break;
                    default:
                        System.out.print("not action");
                }
            }
        } catch (Exception e) {
            System.out.print("有錯誤");
        }
    }
}
