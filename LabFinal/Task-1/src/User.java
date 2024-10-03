import java.util.*;

class User implements Comparable<User> {
    private int id;
    private String fullName;
    private String presentAddress;
    private String userName;

    public User(int id, String fullName, String presentAddress, String userName){
        this.id = id;
        this.fullName = fullName;
        this.presentAddress = presentAddress;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int compareTo(User other) {
        return this.userName.compareTo(other.userName);
    }
    @Override
    public String toString() {
        return "User{id=" + id + ", fullName='" + fullName + "', presentAddress='" + presentAddress +
                "', username='" + userName + "'}";
    }
}

