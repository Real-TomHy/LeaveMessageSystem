package LeaveMessageSystem;
import LeaveMessageSystem.controller.LogupFrameController;
import LeaveMessageSystem.controller.MainFrameController;
import LeaveMessageSystem.controller.MainOrdinaryUserFrameController;
import LeaveMessageSystem.controller.MainTouristFrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;


public class MainApp extends Application {
    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("留言管理系统 ");
        initLogupFrame();

    }

    public static void main(String[] args) {
        launch(args);
    }

    // 登录界面
    public void initLogupFrame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/login.fxml"));
            AnchorPane root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setTitle("登录");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            LogupFrameController controller = loader.getController();

            controller.setStage(primaryStage);

            primaryStage.show();

         } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //管理员主界面

    public void initMainFrame() {
        try {
            // 加载主界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/mainFrame.fxml"));
            AnchorPane root = loader.load();


            // 设置stage舞台的属性
            Stage mainFrameStage = new Stage();

            mainFrameStage.setTitle("留言管理系统主界面");
            mainFrameStage.setResizable(true);
            mainFrameStage.setAlwaysOnTop(false);
            mainFrameStage.initModality(Modality.APPLICATION_MODAL);
            mainFrameStage.initOwner(primaryStage);


            Scene scene = new Scene(root);
            mainFrameStage.setScene(scene);

            MainFrameController controller=loader.getController();
            controller.setStage(mainFrameStage);
            mainFrameStage.showAndWait();




        } catch (IOException e) {
            e.printStackTrace();
          }
  }

    /**
     * 游客界面
     */

    public void initMainTouristFrame() {
        try {
            // 加载主界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/mainTouristFrame.fxml"));
            AnchorPane root = loader.load();


            // 设置stage舞台的属性
            Stage mainFrameStage = new Stage();

            mainFrameStage.setTitle("游客留言管理系统主界面");
            mainFrameStage.setResizable(true);
            mainFrameStage.setAlwaysOnTop(false);
            mainFrameStage.initModality(Modality.APPLICATION_MODAL);
            mainFrameStage.initOwner(primaryStage);


            Scene scene = new Scene(root);
            mainFrameStage.setScene(scene);

            MainTouristFrameController controller=loader.getController();
            controller.setStage(mainFrameStage);
            mainFrameStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 普通用户界面
     */
    public void initMainOrdinaryUserFrame() {
        try {
            // 加载主界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/mainOrdinaryUserFrame.fxml"));
            AnchorPane root = loader.load();


            // 设置stage舞台的属性
            Stage mainFrameStage = new Stage();

            mainFrameStage.setTitle("用户留言管理系统主界面");
            mainFrameStage.setResizable(true);
            mainFrameStage.setAlwaysOnTop(false);
            mainFrameStage.initModality(Modality.APPLICATION_MODAL);
            mainFrameStage.initOwner(primaryStage);


            Scene scene = new Scene(root);
            mainFrameStage.setScene(scene);

            MainOrdinaryUserFrameController controller=loader.getController();
            controller.setStage(mainFrameStage);
            mainFrameStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 用户类别维护界面
     * @return 返回一个AnchorPane便于其他控件调用
     */
    public AnchorPane initUserTypeManageFrame() {
        try {
        // 加载用户类别维护界面
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/userTypeManageFrame.fxml"));
        AnchorPane root = loader.load();
        return root;
          } catch (IOException e) {
            e.printStackTrace();
          }
        return null;
  }

    /**
     * 管理员留言维护
     * @return
     */
    public AnchorPane initMessageManageFrame() {
        try {
            // 加载留言类别维护界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/userMessageManageFrame.fxml"));
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 管理员留言维护
     * @return
     */
    public AnchorPane initOrdinaryUserMessageManageFrame() {
        try {
            // 加载留言类别维护界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/ordinaryuserMessageManageFrame.fxml"));
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 游客留言维护
     * @return
     */
    public AnchorPane initTouristMessageManageFrame() {
        try {
            // 加载留言类别维护界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/touristMessageManageFrame.fxml"));
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 游客注册
     * @return
     */
    public AnchorPane initTouristManageFrame() {
        try {
            // 加载留言类别维护界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/touristRegisterManageFrame.fxml"));
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 留言添加
     * @return
     */
    public AnchorPane initMessageAddManageFrame() {
        try {
            // 加载留言类别维护界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/addMessageFrame.fxml"));
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}