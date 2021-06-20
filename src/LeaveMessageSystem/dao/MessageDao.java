package LeaveMessageSystem.dao;

import LeaveMessageSystem.beans.Message;
import LeaveMessageSystem.beans.UserTypeNewBeanData;
import LeaveMessageSystem.tools.MyDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class MessageDao {
    /**
     * 查询所有的留言
     * @return
     */
    public List<Message> findTableDataList() throws SQLException {
        MyDataSource dataSource=new MyDataSource();
        QueryRunner runner=new QueryRunner(dataSource);
        String sql="select * from message";
        return runner.query(sql,new BeanListHandler<Message>(Message.class));
    }

    /**
     * 删除留言
     * @param parseInt
     * @param name
     * @return
     */
    public int deleteByIdAndname(int parseInt, String name) throws SQLException{
        MyDataSource dataSource=new MyDataSource();
        QueryRunner runner=new QueryRunner(dataSource);
        String sql="delete from message where id=? and name=?";
        int result=runner.update(sql,parseInt,name);
        return result;
    }

    /**
     *  修改留言
     * @param parseInt
     * @param time
     * @param title
     * @param content
     * @return
     */
    public int updateById(int parseInt, String time, String title, String content) throws SQLException{
        MyDataSource dataSource=new MyDataSource();
        QueryRunner runner=new QueryRunner(dataSource);
        String sql = "update message set title=?,content=?,time=? where id=?";
        int result=runner.update(sql,title,content,time,parseInt);
        return result;
    }

    /**
     * 添加留言
     * @param message
     * @return
     */
    public int addMessage(Message message) throws SQLException{
        MyDataSource dataSource=new MyDataSource();
        QueryRunner runner=new QueryRunner(dataSource);
        String sql="insert into message values(?,?,?,?,?)";
        int r= runner.update(sql,null,message.getName(),message.getTitle(),message.getContent(),message.getTime());
        return r;
    }
}
