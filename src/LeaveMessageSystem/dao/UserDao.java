package LeaveMessageSystem.dao;
import java.sql.SQLException;
import java.util.List;

import LeaveMessageSystem.beans.LoginUser;
import LeaveMessageSystem.beans.User;
import LeaveMessageSystem.beans.UserTypeNewBeanData;
import org.apache.commons.dbutils.handlers.BeanHandler;
import LeaveMessageSystem.tools.MyDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class UserDao {
    /**
     * 实现登录
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public LoginUser login(String username, String password) throws SQLException{
        MyDataSource dataSource=new MyDataSource();
        QueryRunner runner=new QueryRunner(dataSource);
        String sql="select * from users where username =? and password =?";
//        return runner.query(sql,new BeanHandler<User>(User.class),username,password);
        return runner.query(sql,new BeanHandler<LoginUser>(LoginUser.class),username,password);
    }
    /**
     * 实现对用户状态查询
     */
    public List<UserTypeNewBeanData> findTableDataList() throws SQLException{
        MyDataSource dataSource=new MyDataSource();
        QueryRunner runner=new QueryRunner(dataSource);
        String sql="select id,username,status from users where roled!=1";
        return runner.query(sql,new BeanListHandler<UserTypeNewBeanData>(UserTypeNewBeanData.class));
    }
    /**
     * 实现对用户状态的管理
     * @return
     */
    public int modifyUser(int id, int status) throws SQLException{
        MyDataSource dataSource=new MyDataSource();
        QueryRunner runner=new QueryRunner(dataSource);
        String sql = "update users set status=? where id=?";
        int result=runner.update(sql,status,id);
        return result;
    }

    /**
     * 游客的注册
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean register(User user) throws SQLException {
        MyDataSource dataSource=new MyDataSource();
        QueryRunner runner=new QueryRunner(dataSource);
        String sql="insert into users values(?,?,?,?,?)";
        int r=runner.update(sql,null,user.getUsername(),user.getPassword(),user.getRoled(),user.getStatus());
        boolean result=false;
        if(r>0){
            result=true;
        }
        return result;
    }
}
