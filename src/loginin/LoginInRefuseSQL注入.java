package loginin;

import Temp.JdbcUtils;

import java.sql.*;
import java.util.Scanner;
//登录方法,使用PreparedStatement实现
public class LoginInRefuseSQL注入 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user=sc.nextLine();
        System.out.println("请输入密码：");
        String password=sc.nextLine();
        boolean flag=new LoginInRefuseSQL注入().login2(user,password);
        if(flag){
            System.out.println("登陆成功");
        }else{
            System.out.println("用户名或密码错误");
        }

    }


    public boolean login2(String username,String pass){
        if(username==null||pass==null){
            return false;
        }
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement pstmt=null;
        try {
//            1.获取链接
            conn = JdbcUtils.getConnection();
//            2。定义SQL ? 要是英文状态下的，否则报错
            String sql="select *from us where username=?and pass=?";
//            3.获取执行sql的对象
            pstmt=conn.prepareStatement(sql);
//            给 “？”赋值
            pstmt.setString(1,username);
            pstmt.setString(2,pass);
//                4.执行查询
            rs=pstmt.executeQuery();
//            5.判断
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtils.close(rs,pstmt,conn);
        }
        return false;
    }


}

