package LeaveMessageSystem.controller;

import LeaveMessageSystem.beans.Message;
import LeaveMessageSystem.beans.UserTypeNewBeanData;
import LeaveMessageSystem.dao.MessageDao;
import LeaveMessageSystem.dao.UserDao;
import LeaveMessageSystem.tools.SimpleTools;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

public class UserMessageManageFrameController {
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
    /**
     * 删除选中的留言
     * @param actionEvent
     */
    public void do_deleteButtom_event(ActionEvent actionEvent) {
        //获取到用户输入内容
        String id=messageIdField.getText();
        String name=messageNameField.getText();

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
        messageTitleField.setEditable(false);
        messageContentField.setEditable(false);
        messageTimeField.setEditable(false);
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
}