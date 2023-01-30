package Models.User;

public class User {


    private String name;
    private String userName;
    private String passWord;

    private String img;

    private int role;


    public User() {
    }

    public User(String name, String userName, String passWord, String img, int role) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.img = img;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
