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

public class MainOrdinaryUserFrameController {
    public MenuItem MessageAddMenuItem;
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
    public AnchorPane mainFrameAnchorPane;
    public ImageView mainAdminImageView;

    /**
     * 进入普通用户界面
     * @param actionEvent
     */
    public void do_MessageBrowserMenuItem_event(ActionEvent actionEvent) {
        AnchorPane pane =new MainApp().initOrdinaryUserMessageManageFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }
    /**
     * 退出
     * @param actionEvent
     */
    public void do_exitMenuItem_vent(ActionEvent actionEvent) {
        // 退出菜单项的事件处理
        System.exit(0);
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
     * 留言添加
     * @param actionEvent
     */
    public void do_MessageAddMenuItem(ActionEvent actionEvent) {
        AnchorPane pane =new MainApp().initMessageAddManageFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }
}
