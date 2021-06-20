package LeaveMessageSystem.beans;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserTypeNewBeanData {
    private int id;

    public UserTypeNewBeanData(int id, String username, int status) {
        this.id = id;
        this.username = username;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserTypeNewBeanData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", status=" + status +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserTypeNewBeanData() {
    }
    public SimpleStringProperty idProperty() {
        String newid=id+"";
        SimpleStringProperty idfx=new SimpleStringProperty(newid);
        return idfx;
    }
    public SimpleStringProperty statusProperty() {
        String newstatus=status+"";
        //需将int转成integer
        SimpleStringProperty statusfx=new SimpleStringProperty(newstatus);
        return statusfx;
    }
    public SimpleStringProperty usernameProperty() {
        SimpleStringProperty usernamefx=new SimpleStringProperty(username);
        return usernamefx;
    }
    private String username;
    private int status;

}
