package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
//验证最大连接数
public class c3p0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1．获取DataSource．使用默认配置,传入参数则使用对应的配置

        DataSource ds= new ComboPooledDataSource();
        for (int i = 1; i < 15; i++) {
            Connection conn=ds.getConnection();
            System.out.println(i+" "+conn);
//            归还后访问最大连接数可以超过配置文件
            if(i>3){
                conn.close();
            }
        }
    }
}
