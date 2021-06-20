package LeaveMessageSystem.tools;
import LeaveMessageSystem.beans.Message;
import LeaveMessageSystem.beans.UserTypeNewBeanData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Optional;
public class SimpleTools {

    /**
         * 操作结果：JavaFX设置按钮、标签等组件的图标
         *
         * @param labeleds   需要设置图标的按钮
         * @param imagePaths 图标的路径
         */
    public void setLabeledImage(Labeled[] labeleds, String[] imagePaths) {
        for (int i = 0; i < labeleds.length; i++) {
            labeleds[i].setGraphic(new ImageView(new Image("file:" + imagePaths[i])));
        }
    }

      /**
    * 操作结果：清空文本框组件的内容
    *
    * @param inputControls 文本框或文本域组等
    */
    public void clearTextField(TextInputControl... inputControls) {
        for (int i = 0; i < inputControls.length; i++) {
            inputControls[i].setText("");
        }
 }

      /**
         * 操作结果：取消所有单选按钮选择
         *
         * @param toggleButtons 单选按钮组
         */
    public void clearSelectedRadioButton(ToggleButton... toggleButtons) {
        for (int i = 0; i < toggleButtons.length; i++) {
            toggleButtons[i].setSelected(false);
        }
    }

    /**
     * 操作结果：取消所有下拉列表框选择
     *
     * @param comboBoxes 下拉列表框组
     */
    public void clearSelectedComboBox(ComboBox... comboBoxes) {
        for (int i = 0; i < comboBoxes.length; i++) {
            comboBoxes[i].getSelectionModel().select(-1);// 设置选择的索引为-1，就不会选择任何选择选项了。
        }
    }

    /**
     * 操作结果：JavaFX设置菜单项组件的图标
     *
     * @param menuItems  菜单项
      * @param imagePaths 图标的路径
    */
    public void setMenuItemImage(MenuItem[] menuItems, String[] imagePaths) {
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].setGraphic(new ImageView(new Image("file:" + imagePaths[i])));
        }
    }

      /**
     * 操作结果：JavaFX判断是否为空
     *
     * @param str 文本
     * @return boolean 如果不为空返回true，否则返回false
     */
    public boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
          } else {
            return false;
        }
        }

    /**
    * 操作结果：自定义一个JavaFX的对话框
    *
    * @param alterType 对话框类型
    * @param title     对话框标题
    * @param header    对话框头信息
    * @param message   对话框显示内容
    * @return boolean 如果点击了”确定“那么就返回true，否则返回false
    */
    public static boolean informationDialog(Alert.AlertType alterType, String title, String header, String message) {
        // 按钮部分可以使用预设的也可以像这样自己 new 一个
        Alert alert = new Alert(alterType, message, new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE), new ButtonType("确定", ButtonBar.ButtonData.YES));
        // 设置对话框的标题
        alert.setTitle(title);
        alert.setHeaderText(header);
        // showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> buttonType = alert.showAndWait();
        // 根据点击结果返回
        if (buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
            return true;// 如果点击了“确定”就返回true
          } else {
            return false;
              }
        }

            /**
     * 操作结果：JavaFX判断是否登录成功
      *
     * @param userNameTextField 用户名文本框
     * @param passwordTextField 密码文本框
     * @param userName   正确用户名
     * @param password   正确密码
     * @return boolean 如果登录成功返回true，否则返回false
      */
            public boolean isLogIn(TextInputControl userNameTextField, TextInputControl passwordTextField, String userName, String password) {
                SimpleTools simpleTools = new SimpleTools();
                if (simpleTools.isEmpty(userNameTextField.getText())) {
                    simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "用户名不能为空！");
                    return false;
                }
                if (simpleTools.isEmpty(passwordTextField.getText())) {
                    simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "密码不能为空！");
                    return false;
                }
                if (!userNameTextField.getText().equals(userName)) {
                    simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "用户名不正确！");
                    return false;
                }
                if (!passwordTextField.getText().equals(password)) {
                    simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "密码不正确！");
                    return false;
                }
                if (!userNameTextField.getText().equals(userName) && !passwordTextField.getText().equals(password)) {
                    simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "用户名和密码均不正确！");
                     return false;
                }
                if (userNameTextField.getText().equals(userName) && passwordTextField.getText().equals(password)) {
                    boolean isOK = simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "登录成功！");
                    return isOK;
                }
            return false;
  }

        /**
         * 操作结果：向下拉列表框中添加列表项
         *
         * @param comboBox 下拉列表框
         * @param items    列表项
          */
        public void addComboBoxItems(ComboBox comboBox, Object[] items) {
            comboBox.getItems().clear();// 清除下列列表框中的所有选项
            ObservableList options = FXCollections.observableArrayList(items);
            comboBox.setItems(options);// 添加下拉列表项
   }

    /**
     * 将查询的用户状态结果，放到表中
     * @param userTypeManageView
     * @param data
     * @param idTableColumn
     * @param userTypeNameColumn
     * @param userTypeStatus
     */
    public void setUserTypeTableViewData(TableView<UserTypeNewBeanData> userTypeManageView,ObservableList data, TableColumn<UserTypeNewBeanData , String> idTableColumn, TableColumn<UserTypeNewBeanData, String> userTypeNameColumn, TableColumn<UserTypeNewBeanData, String> userTypeStatus) {
        //设置id列数据
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());

        //设置name列数据
        userTypeNameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        //设置status列数据
        userTypeStatus.setCellValueFactory(cellData ->  cellData.getValue().statusProperty());
        userTypeManageView.setItems(data);
    }
    /**
     * 把数据放到表中
     * @param messageTypeManageView
     * @param data
     * @param messageIdColumn
     * @param messageNameColumn
     * @param messageTitleColumn
     * @param messageContentColumn
     * @param messageTimeColumn
     */
    public void setMessageTableViewData(TableView<Message> messageTypeManageView, ObservableList<Message> data, TableColumn<Message, String> messageIdColumn, TableColumn<Message, String> messageNameColumn, TableColumn<Message, String> messageTitleColumn, TableColumn<Message, String> messageContentColumn, TableColumn<Message, String> messageTimeColumn) {
        //id列数据
        messageIdColumn.setCellValueFactory(cellData -> cellData.getValue().midProperty());
        //name列数据
        messageNameColumn.setCellValueFactory(cellData -> cellData.getValue().mnameProperty());
        //title列数据
        messageTitleColumn.setCellValueFactory(cellData -> cellData.getValue().mtitleProperty());
        //content列数据
        messageContentColumn.setCellValueFactory(cellData -> cellData.getValue().mcontentProperty());
        //time列数据
        messageTimeColumn.setCellValueFactory(cellData -> cellData.getValue().mtimeProperty());
        messageTypeManageView.setItems(data);
    }
    /**
     * 将数据库拿到data数据封装转换成javafx中 ObservableList<BookTypeBeanTableData>类型的数据
     */
    public ObservableList<UserTypeNewBeanData> getUserTypeTableViewData(List<UserTypeNewBeanData> tableDataList) {

        // 创建ObservableList<BookTypeBeanTableData>对象
        ObservableList<UserTypeNewBeanData> data = FXCollections.observableArrayList();
        // 循环遍历集合中的数据
        for (int i = 0; i < tableDataList.size(); i++) {
            UserTypeNewBeanData r = (UserTypeNewBeanData) tableDataList.get(i);
            // 将数据封装到BookTypeBeanTableData中
            UserTypeNewBeanData td = new UserTypeNewBeanData(r.getId(), r.getUsername(), r.getStatus());
            // 将BookTypeBeanTableData对象添加到data中
            data.add(td);
        }
        // 返回数据
        return data;
    }
    /**
     * 将数据库拿到data数据封装转换成javafx中 ObservableList<Message>类型的数据
     * @param messageDataList
     * @return
     */
    public ObservableList<Message> getMessageTableViewData(List<Message> messageDataList) {
        // 创建ObservableList<BookTypeBeanTableData>对象
        ObservableList<Message> data = FXCollections.observableArrayList();
        // 循环遍历集合中的数据
        for (int i = 0; i < messageDataList.size(); i++) {
            Message r = (Message) messageDataList.get(i);
            // 将BookTypeBeanTableData对象添加到data中
            data.add(r);
        }
        // 返回数据
        return data;
    }
    /**
     *  这是自己定义一个提示框
     * @param alterType
     * @param title
     * @param header
     * @param message
     * @return
     */
    public boolean informationDalog(Alert.AlertType alterType, String title, String header, String message) {
        // 按钮部分可以使用预设的也可以像这样自己 new 一个
        Alert alert = new Alert(alterType, message, new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE), new ButtonType("确定", ButtonBar.ButtonData.YES));
        // 设置对话框的标题
        alert.setTitle(title);
        alert.setHeaderText(header);
        // showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> buttonType = alert.showAndWait();
        // 根据点击结果返回
        if (buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
            return true;// 如果点击了“确定”就返回true
          } else {
            return false;
         }
    }


}





