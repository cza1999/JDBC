package druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil2Test {
    public static void main(String[] args) {
        PreparedStatement pstmt=null;
        Connection conn=null;
        try {
//       1. 获取连接
            conn=JdbcUtil2.getConnection();
//            2.定义SQL
            String sql="insert into account(balance) values(?)";
//            3.获取pstmt对象
            pstmt=conn.prepareStatement(sql);
//            4给? 赋值
            pstmt.setInt(1,3000);
//            5,执行SQL
            int count = pstmt.executeUpdate();
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtil2.close(null,pstmt,conn);
        }


    }
}
