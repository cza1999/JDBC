package 事务;

import Temp.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 转账 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;

//            1.获取连接
            try {
                conn= JdbcUtils.getConnection();
//                开启事务
                conn.setAutoCommit(false);
//                2.定义SQL
                String sql1= "update account set balance=balance-? where id=?";
                String sql2= "update account set balance=balance+? where id=?";
//            3.获取执行对象
                pstmt1 =conn.prepareStatement(sql1);
                pstmt2 =conn.prepareStatement(sql2);
//            4.设置参数
                pstmt1.setDouble(1,50);
                pstmt1.setInt(2,1);

                pstmt2.setDouble(1,500);
                pstmt2.setInt(2,3);
//                5.执行
                pstmt1.executeUpdate();
//                手动制造异常
//              int i=3/0;
                pstmt2.executeUpdate();

            } catch (Exception throwable) {
//                事务回滚
                try {
                    if (conn!=null) {
                        conn.rollback();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                throwable.printStackTrace();
            }finally{
                JdbcUtils.close(null,pstmt1,conn);
                JdbcUtils.close(null,pstmt2,null);
            }


    }

}
