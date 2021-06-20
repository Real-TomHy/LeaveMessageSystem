package LeaveMessageSystem.controller;

import LeaveMessageSystem.beans.UserTypeNewBeanData;
import LeaveMessageSystem.dao.UserDao;
import LeaveMessageSystem.tools.SimpleTools;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户注册管理
 */
public class UserTypeManageFrameController {
    @FXML
    public TableView<UserTypeNewBeanData> UserTypeManageView;
    @FXML
    public TableColumn<UserTypeNewBeanData,String> idTableColumn;
    @FXML
    public TableColumn<UserTypeNewBeanData,String> userTypeNameColumn;
    @FXML
    public TableColumn<UserTypeNewBeanData, String> userTypeStatus;
    @FXML
    public VBox formVbox;
    @FXML
    public TextField idTextField;
    @FXML
    public TextField userTypeNameField;
    @FXML
    public TextField userTypeStatusField;
    @FXML
    public Button checkButton;
    @FXML
    public Button alterButton;
    private SimpleTools simpleTools=new SimpleTools();
    private UserDao userDao=new UserDao();

    /**
     * 修改事件，即对用户实现启用或禁用
     * @param actionEvent
     */
    public void do_alterButtom_event(ActionEvent actionEvent) {
        //获取到用户输入内容
        String id=idTextField.getText();
        String status=userTypeStatusField.getText();
        if(status==null||status.equals("")){
            simpleTools.informationDalog(Alert.AlertType.ERROR, "提示", "错误", "不可为空！");
            return;
        }
        //实例化UserDao对象
        UserDao dao=new UserDao();
        //更新结果
        int result=0;
        //更新
        try {
            result=dao.modifyUser(Integer.parseInt(id),Integer.parseInt(status));
            if(result>0) {
                //更新成功 清空各文本框并弹出提示框
                initialize();
                simpleTools.clearTextField(idTextField, userTypeNameField, userTypeStatusField);
                simpleTools.informationDalog(Alert.AlertType.INFORMATION, "提示", "信息", "修改成功");
            }
            else {
                //更新失败  给出提示
                simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "修改失败！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //更新失败  给出提示
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "修改失败！");
        }
    }


    /**
     * 初始化界面数据
     */
    public void initialize(){
        // 实例化UserDao对象
        UserDao userDao = new UserDao();
        //为id文本框设置不可编辑
        idTextField.setEditable(false);
        //name也是不可修改
        userTypeNameField.setEditable(false);
        //查询用户
        List<UserTypeNewBeanData> userTypeNewBeanDataList=null;
        try {
            userTypeNewBeanDataList=userDao.findTableDataList();
            //将数据库数据转换成javafx需要的数据
            ObservableList<UserTypeNewBeanData> data=simpleTools.getUserTypeTableViewData(userTypeNewBeanDataList);
            //将数据加入到表格中
            simpleTools.setUserTypeTableViewData(UserTypeManageView,data,idTableColumn,userTypeNameColumn,userTypeStatus);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //为表格控件注册事件监听
        UserTypeManageView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showUserTypeDetails(newValue)));
    }
    /**
     * 选中行后将数据显示到下面文本框中
     */
    public void showUserTypeDetails(UserTypeNewBeanData userTypeNewBeanData){
        //判断是否选中
        if(userTypeNewBeanData==null){
            return;
        } else {
            //如果表格行被选中，把数据显示在下面
            idTextField.setText(userTypeNewBeanData.getId()+"");
            userTypeNameField.setText(userTypeNewBeanData.getUsername());
            userTypeStatusField.setText(userTypeNewBeanData.getStatus()+"");
        }
    }

}
