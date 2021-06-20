package LeaveMessageSystem.controller;

import LeaveMessageSystem.beans.LoginUser;
import LeaveMessageSystem.beans.Message;
import LeaveMessageSystem.beans.Session;
import LeaveMessageSystem.dao.MessageDao;
import LeaveMessageSystem.tools.SimpleTools;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

public class OrdinaryUserMessageManageFrameController {
    public TableView<Message> MessageTypeManageView;
    public TableColumn<Message,String> messageIdColumn;
    public TableColumn<Message,String> messageNameColumn;
    public TableColumn<Message,String> messageTitleColumn;
    public TableColumn<Message,String> messageContentColumn;
    public TableColumn<Message,String> messageTimeColumn;
    public VBox formVbox;
    public TextField messageIdField;
    public TextField messageNameField;
    public TextField messageTimeField;
    public TextField messageTitleField;
    public TextField messageContentField;
    public Button deleteButton;
    // 实例化MesageDao对象
    MessageDao messageDao=new MessageDao();
    private SimpleTools simpleTools=new SimpleTools();
    LoginUser loginUser= Session.getLoginUser();
    //获取到通话对象
    String username=loginUser.getUsername();
    /**
     * 删除选中的留言
     * @param actionEvent
     */
    public void do_deleteButtom_event(ActionEvent actionEvent) {
        //获取到用户输入内容
        String id=messageIdField.getText();
        String name=messageNameField.getText();

        if(!name.equals(username)){
            simpleTools.informationDalog(Alert.AlertType.INFORMATION, "提示", "重要提示", "您无权删除！");
            return;
        }
        //实例化UserDao对象
        MessageDao messageDao=new MessageDao();
        //更新结果
        int result=0;
        //删除
        try {
            result=messageDao.deleteByIdAndname(Integer.parseInt(id),name);
            if(result>0){
                //删除成功 清空各文本框并弹出提示框
                initialize();
                simpleTools.clearTextField(messageIdField,messageNameField,messageTimeField,messageContentField,messageTimeField);
                simpleTools.informationDalog(Alert.AlertType.INFORMATION, "提示", "信息", "删除成功");
            }
            else {
                simpleTools.informationDalog(Alert.AlertType.INFORMATION, "提示", "信息", "删除失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    /**
     * 初始化界面数据
     */
    public void initialize(){

        //为各种文本框设置不可编辑
        messageIdField.setEditable(false);
        messageNameField.setEditable(false);
        //查询留言
        List<Message> messageDataList=null;
        try {
            messageDataList=messageDao.findTableDataList();
            //将数据库数据转换成javafx需要的数据
            ObservableList<Message> data=simpleTools.getMessageTableViewData(messageDataList);
            //将数据加入到表格中
            simpleTools.setMessageTableViewData(MessageTypeManageView,data,messageIdColumn,messageNameColumn,messageTitleColumn,messageContentColumn,messageTimeColumn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //为表格控件注册事件监听
        MessageTypeManageView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showMessageDetails(newValue)));
    }
    /**
     * 选中行后将数据显示到下面文本框中
     */
    private void showMessageDetails(Message newValue) {
        //判断是否选中
        if(newValue==null){
            return;
        } else {
            //如果表格行被选中，把数据显示在下面
            messageIdField.setText(newValue.getId()+"");
            messageNameField.setText(newValue.getName());
            messageTitleField.setText(newValue.getTitle());
            messageContentField.setText(newValue.getContent());
            messageTimeField.setText(newValue.getTime());
        }
    }

    /**
     * 修改
     * @param actionEvent
     */
    public void do_alterButtom_event(ActionEvent actionEvent) {
        //获取到用户输入
        String id=messageIdField.getText();
        String name=messageNameField.getText();
        String time=messageTimeField.getText();
        String title=messageTitleField.getText();
        String content=messageContentField.getText();
        if(!name.equals(username)){
            simpleTools.informationDalog(Alert.AlertType.WARNING, "提示", "重要提示", "您无权修改！");
            return;
        }
        if(title==null||title.equals("")||time==null||time.equals("")||content==null||content.equals("")){
            simpleTools.informationDalog(Alert.AlertType.WARNING, "提示", "警告", "修改不可为空！");
            return;
        }
        //修改结果
        int result=0;
        //修改
        try {
            result=messageDao.updateById(Integer.parseInt(id),time,title,content);
            if(result>0){
                //删除成功 清空各文本框并弹出提示框
                initialize();
                simpleTools.clearTextField(messageIdField,messageNameField,messageTimeField,messageContentField,messageTimeField);
                simpleTools.informationDalog(Alert.AlertType.INFORMATION, "提示", "成功", "修改成功！");
            }
            else {
                simpleTools.informationDalog(Alert.AlertType.ERROR, "提示", "失败", "修改失败！");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            simpleTools.informationDalog(Alert.AlertType.ERROR, "提示", "失败", "修改失败！");

        }
    }
}