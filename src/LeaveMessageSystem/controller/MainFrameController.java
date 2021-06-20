package LeaveMessageSystem.controller;

import LeaveMessageSystem.MainApp;
import LeaveMessageSystem.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;


public class MainFrameController {
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
    private MenuItem MessageManageMenuItem;

    @FXML
    public ImageView mainAdminImageView;

    @FXML
    private AnchorPane mainFrameAnchorPane;

    @FXML
    private MenuItem MessageBrowserMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem UserMenuItem_event;

    @FXML
    private MenuItem aboutSoftMenuItem;


    /**
     * 初始化启动
     */
    public void initialize(){
        //设置图片
        InputStream is;
        Image image=new Image("file:src/LeaveMessageSystem/images/bk2.jpg");
        mainAdminImageView.setImage(image);
    }

    /*
        退出键
     */
    public void do_exitMenuItem_vent(ActionEvent event) {
        // 退出菜单项的事件处理
        System.exit(0);
    }

    public void do_aboutSoftMenuItem_event(ActionEvent event) {

    }


    /*
        进入用户管理界面
     */
    public void do_UserMenuItem_event(ActionEvent event) {
       AnchorPane pane =new MainApp().initUserTypeManageFrame();
       mainFrameAnchorPane.getChildren().clear();
       mainFrameAnchorPane.getChildren().add(pane);

    }

    /**
     * 进入留言界面
     * @param event
     */
   public void do_MessageBrowserMenuItem_event(ActionEvent event) {
       AnchorPane pane =new MainApp().initMessageManageFrame();
       mainFrameAnchorPane.getChildren().clear();
       mainFrameAnchorPane.getChildren().add(pane);
    }
}
