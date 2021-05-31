package models;

public class User {
    private int id ;
    private String email;
    private  String password ;
    private  String role ;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public User(){
        super();
    }

    public  User(int id , String email , String password , String role ) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role ;
    }

}
