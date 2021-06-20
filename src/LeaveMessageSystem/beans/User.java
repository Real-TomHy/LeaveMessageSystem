package LeaveMessageSystem.beans;

public class User {
//    `id` int(5) NOT NULL,
//                         `username` varchar(40) NOT NULL,
//                         `password` varchar(20) NOT NULL,
//                         `roled` int NOT NULL,
//            `status` int NOT NULL,
    private int id;
    private String username;
    private String password;
    private int roled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getRoled() {
        return roled;
    }

    public void setRoled(int roled) {
        this.roled = roled;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;
}
