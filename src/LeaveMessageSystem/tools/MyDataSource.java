package LeaveMessageSystem.tools;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource{
//    1.创建一个容器用于存放Connection对象
    private static LinkedList<Connection> pool=new LinkedList<Connection>();
//    2.创建5个连接放到容器中
    static {
        for (int i=0;i<5;i++){
            Connection conn= JDBCUtil_V3.getConnection();
            pool.add(conn);
        }
}
/**
 *获取重新连接的方法
 */
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn=null;
//        3.使用前的预处理
        if (pool.size() == 0) {
            for (int i = 0; i < 5; i++) {
                conn = JDBCUtil_V3.getConnection();
                pool.add(conn);
//                System.out.println("执行了");
            }

        }
        //            4.从池子里面获取一个连接对象
        conn = pool.remove();
        return conn;

    }
    /**
     *归还对象到连接池
     */
    public void backPoll(Connection conn){
        pool.add(conn);
    }
    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
