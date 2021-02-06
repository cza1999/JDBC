package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil2 {
    //    1.定义成员变量
    private static DataSource ds;

    static {
        try {
            //     加载配置文件
            Properties pro = new Properties();
            pro.load(JdbcUtil2.class.getClassLoader().getResourceAsStream("druid.properties"));
//                获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //            获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //            释放资源
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //    获取连接池
    public static DataSource getDataSource() {
        return ds;
    }

}

