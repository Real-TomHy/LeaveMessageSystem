package LeaveMessageSystem.controller;

import LeaveMessageSystem.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;

public class MainTouristFrameController {
    public MenuItem loginMenuItem;
    @FXML
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public MenuItem MessageBrowserMenuItem;
    public MenuItem exitMenuItem;
    public MenuItem registerMenuItem;
    public AnchorPane mainFrameAnchorPane;
    public ImageView mainAdminImageView;

    /**
     * 退出
     * @param actionEvent
     */
    public void do_exitMenuItem_vent(ActionEvent actionEvent) {
        // 退出菜单项的事件处理
        System.exit(0);
    }

    /**
     * 注册
     * @param actionEvent
     */
    public void do_registerMenuItem_event(ActionEvent actionEvent) {
        AnchorPane pane =new MainApp().initTouristManageFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);

    }

    /**
     * 查看所有留言
     * @param actionEvent
     */
    public void do_MessageBrowserMenuItem_event(ActionEvent actionEvent) {
        AnchorPane pane =new MainApp().initTouristMessageManageFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }
    /**
     * 初始化启动
     */
    public void initialize(){
        //设置图片
        InputStream is;
        Image image=new Image("file:src/LeaveMessageSystem/images/bk2.jpg");
        mainAdminImageView.setImage(image);
    }

    /**
     * 返回登录
     * @param actionEvent
     */
    public void do_loginMenuItem_vent(ActionEvent actionEvent) {
        // 跳转到主界面后，关闭登录界面
        stage.close();
        // 打开主窗口
        new MainApp().start(stage);
    }
}
