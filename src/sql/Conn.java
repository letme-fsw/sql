package sql;

import java.sql.*; //导入java.sql包
import  java.util.*;

public class Conn { // 创建类Conn
    Connection con; // 声明Connection对象
    public static String user;
    public static  String passord;
    public Connection getConnection() { // 建立返回值为Connection的方法
        try { // 加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数据库用户名：");
        String user1 = in.next();
        user = user1;
        System.out.println("请输入数据库密码：");
        String passord1 = in.next();
        passord = passord1;
        try { // 通过访问数据库的URL获取数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk"
                    , user1, passord1);
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con; // 按方法要求返回一个Connection对象
    }

}
