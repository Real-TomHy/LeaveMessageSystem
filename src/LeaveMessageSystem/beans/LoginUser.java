package LeaveMessageSystem.beans;

public class LoginUser {
    public int status;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int roled;

    public int getRoled() {
        return roled;
    }

    public void setRoled(int roled) {
        this.roled = roled;
    }
}
