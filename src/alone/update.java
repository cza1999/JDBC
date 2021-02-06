package alone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class update {
    public static void main(String[] args) throws Exception{
//        1.导入驱动jar包。
//        2.注册驱动mysql5之后可以省略
       Class.forName("com.mysql.cj.jdbc.Driver");
//        3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","zxcvbnm1999");
//        4.定义sql语句
        String sql="update book set booknum='333' where cou='109'";
//        5.获取执行sql的对象， Statement
        Statement stat =conn.createStatement();
//        6.执行sql
        int count =stat.executeUpdate(sql);
//        7.处理结果
        System.out.println(count);
        stat.close();
        conn.close( );

    }
}
