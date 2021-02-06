package loginin;
import Temp.JdbcUtils;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user=sc.nextLine();
        System.out.println("请输入密码：");
//        SELECT * FROM book.us where username='gfds' and pass= 'a' or '1'='1' ;
//        sql注入 用户名 随便写 密码 最后恒等   也能登录成功；
        String password=sc.nextLine();
        boolean flag=new LoginIn().login(user,password);
        if(flag){
            System.out.println("登陆成功");
        }else{
            System.out.println("用户名或密码错误");
        }

    }


    public boolean login(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        try {
            conn = JdbcUtils.getConnection();
            String sql="select *from us where username='"+username+"'and pass='"+password+"'";
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtils.close(rs,stat,conn);
        }
        return false;
    }


}
