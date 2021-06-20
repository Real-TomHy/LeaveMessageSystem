package LeaveMessageSystem.controller;

import LeaveMessageSystem.beans.User;
import LeaveMessageSystem.dao.UserDao;
import LeaveMessageSystem.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.SQLException;

public class TouristRegisterManageFrameController {
    public VBox formVbox;
    public TextField tNameField;
    public PasswordField tPasswordField;
    public PasswordField tPasswordCkField;
    public Button deleteButton;
    public Button resetButton;

    /**
     * 处理游客注册事件
     * @param actionEvent
     */
    public void do_deleteButtom_event(ActionEvent actionEvent) {
        if (tNameField.getText().equals("") || tPasswordField.getText().equals("")|| tPasswordCkField.getText().equals("")) {
            SimpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "请按照文本框内容提示正确填写内容！");
        } else if(!tPasswordField.getText().equals(tPasswordCkField.getText())){
            SimpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "请确认密码一致！");
        } else {
            //注册
            User user=new User();
            user.setUsername(tNameField.getText());
            user.setPassword(tPasswordField.getText());
            user.setRoled(2);
            user.setStatus(1);
            UserDao userDao=new UserDao();
            boolean result=false;
            try {
                result=userDao.register(user);
                if(result=true){
                    SimpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "反馈", "已经成功注册!");
                }
                else {
                    SimpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "反馈", "注册失败!");

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                SimpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "反馈", "注册失败!");

            }
        }
    }
    // “重置”按钮的事件监听器方法
    public void resetButtonEvent(ActionEvent actionEvent) {
        tNameField.setText("");
        tPasswordField.setText("");
        tPasswordCkField.setText("");
    }
}
