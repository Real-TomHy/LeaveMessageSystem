package LeaveMessageSystem.beans;

public class Session {
    private static User user;
    private static LoginUser loginUser;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Session.user = user;
    }

    public static LoginUser getLoginUser() {
        return loginUser;
    }

    public static void setLoginUser(LoginUser loginUser) {
        Session.loginUser = loginUser;
    }
}
