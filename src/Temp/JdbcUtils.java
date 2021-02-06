package Temp;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
//    读取资源文件,获取值
    static {
        try {
//        1.创建Properties集合类
            Properties pro = new Properties();
            //获取src路径下的文件方式:ClassLoader类加载器
            ClassLoader classloader =JdbcUtils.class.getClassLoader();
            URL res =classloader.getResource("jdbc.properties");
            String path =res.getPath();
            System.out.println(path);
//            2.加载文件
            pro.load(new FileReader(path));
//            pro.load(new FileReader("src/jdbc.properties"));
            //            3.获取数据,赋值
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
//            4.注册
            try {
                Class.forName("driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
//    获取对象
    public  static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
//    释放资源
    public  static void close(ResultSet rs,Statement stat, Connection conn){
        if(stat!=null){
            try{
                stat.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if(rs!=null){
            try{
                rs.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
