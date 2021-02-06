package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class c3p0 {
    public static void main(String[] args) throws Exception {
//        1,创建数据库连接池
        DataSource ds=new ComboPooledDataSource();
//        2.获取连接对象
        Connection conn=ds.getConnection();
        System.out.println(conn);


    }
}
