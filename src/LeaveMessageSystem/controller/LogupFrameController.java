package LeaveMessageSystem.controller;
import LeaveMessageSystem.MainApp;
import LeaveMessageSystem.beans.LoginUser;
import LeaveMessageSystem.beans.Session;
import LeaveMessageSystem.dao.UserDao;
import LeaveMessageSystem.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;


public class LogupFrameController {
    public Button touristButton;
    private SimpleTools simpleTools = new SimpleTools();
    @FXML
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button logupButton;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label systemLabel;

    @FXML
    private Button resetButton;

    @FXML
    private Label passwordLabel;

    // “登录”按钮的事件监听器方法
    public void logupButtonEvent(ActionEvent event) throws Exception{
//        stage.close();
//        boolean isOK = simpleTools.isLogIn(userNameTextField, passwordTextField, "张三", "123456");
//        if (isOK) {
//            // 如果登录成功则跳转到主界面
//            // new MainApp().initMainFrame();
//        }


        if (userNameTextField.getText().equals("") || passwordTextField.getText().equals("")) {
            SimpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "请按照文本框内容提示正确填写内容！");
        } else {
            // 实例化UserDao对象
            UserDao userDao = new UserDao();
            // 登录用户
            LoginUser loginUser = null;
            try {
                loginUser = userDao.login(userNameTextField.getText(), passwordTextField.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(loginUser!=null) {
                // 对是否登录成功进行判断
                if (loginUser.getUsername() != null && loginUser.getPassword() != null) {
                // roled用户状态
                    int roled=loginUser.getRoled();
//                // 设置通信对象，建立登录成功通信
//                Session.setUser(loginUser);
                    // 在弹出的提示框种获取用户反馈
                    boolean b = SimpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "恭喜登录成功，欢迎使用本系统！");
                    // 如果用户确定登录，则跳转到主界面
                    if (b) {
                        //获取当前ip
//                        InetAddress ip4 = Inet4Address.getLocalHost();
//                        String[] strs=String.valueOf(ip4).split("/");
//                        String ip=strs[1];
//                        System.err.println(ip);
                        // 跳转到主界面后，关闭登录界面
                        stage.close();
                        if(roled==1) {
                            // 打开主窗口
                            new MainApp().initMainFrame();
                        }
                        else {
                            //设置session通信对象
                            Session.setLoginUser(loginUser);
                            //普通用户主界面
                            new MainApp().initMainOrdinaryUserFrame();
                        }

                    }

                } else {
                    SimpleTools.informationDialog(Alert.AlertType.ERROR, "错误", "错误", "用户名或密码错误！");
                }
            }else {
                SimpleTools.informationDialog(Alert.AlertType.ERROR, "错误", "错误", "用户名或密码错误！");
            }
        }
    }



   // “重置”按钮的事件监听器方法
   public void resetButtonEvent(ActionEvent event) {
       userNameTextField.setText("");
       passwordTextField.setText("");
  }
    //游客登录
    public void touristButtonEvent(ActionEvent actionEvent) {
        // 跳转到主界面后，关闭登录界面
        stage.close();
        // 打开主窗口
        new MainApp().initMainTouristFrame();
    }
}