package Entity;

public class Account {
    private int id;
    private String username;
    private String password;
    private String email;
    private String createdAt;
    private int accountType;

    public Account() {}

    public Account(int id, String username, String password, String email,String createdAt,int accountType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountType = accountType;
        this.createdAt = createdAt;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}
