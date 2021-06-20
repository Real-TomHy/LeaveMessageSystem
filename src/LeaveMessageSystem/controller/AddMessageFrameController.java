package LeaveMessageSystem.controller;

import LeaveMessageSystem.beans.LoginUser;
import LeaveMessageSystem.beans.Message;
import LeaveMessageSystem.beans.Session;
import LeaveMessageSystem.dao.MessageDao;
import LeaveMessageSystem.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddMessageFrameController {
    public Label descriptionLabel;
    public TextField titleTextField;
    public TextArea contentTextField;
    public DatePicker datePickerTextField;
    public Button addButton;
    public Button resetButton;
    // 实例化MesageDao对象
    MessageDao messageDao=new MessageDao();
    private SimpleTools simpleTools=new SimpleTools();
    LoginUser loginUser= Session.getLoginUser();
    //获取到通话对象
    String username=loginUser.getUsername();
    int status= loginUser.getStatus();

    /**
     *  添加
     * @param actionEvent
     */
    public void addButtonEvent(ActionEvent actionEvent) {
        if(status==1){
            simpleTools.informationDalog(Alert.AlertType.INFORMATION, "提示", "信息", "您的账号尚未被管理员激活");
            return;
        }
        //标题
        String title=titleTextField.getText();
        //内容
        String content=contentTextField.getText();
        // 日期
        String date = datePickerTextField.getValue().toString();
        if(title==null||title.equals("")||content==null||content.equals("")||date==null||date.equals("")){
            simpleTools.informationDalog(Alert.AlertType.WARNING, "提示", "信息", "留言不可为空");
        }
        //实例化Message
        Message message=new Message();
        //封装
        message.setName(username);
        message.setTitle(title);
        message.setContent(content);
        message.setTime(date);
        //添加结果
        int result=0;
        try {
            result=messageDao.addMessage(message);
            if(result>0){
                simpleTools.informationDalog(Alert.AlertType.INFORMATION, "提示", "信息", "留言成功");
            }
            else {
                simpleTools.informationDalog(Alert.AlertType.ERROR, "提示", "失败", "留言失败");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 重置
     * @param actionEvent
     */
    public void resetButtonEvent(ActionEvent actionEvent) {
        titleTextField.setText("");
        contentTextField.setText("");
        //String转localdate
//        String date="";
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date2 = LocalDate.parse(date, fmt);
    }
}
