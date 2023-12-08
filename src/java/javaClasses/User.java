package javaClasses;

/**
 *
 * @author raj94
 */
public class User {
    private int uid;
    private String name;
    private String gender;
    private String address;
    private int contactNum;
    private String email;
    private String password;

    public User() {
    }

    public User(int uid, String name, String gender, String address, int contactNum, String email, String password) {
        this.uid = uid;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.contactNum = contactNum;
        this.email = email;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public int getContactNum() {
        return contactNum;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getUid() {
        return uid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" + "uid=" + uid + ", name=" + name + ", gender=" + gender + ", address=" + address + ", contactNum=" + contactNum + ", email=" + email + ", password=" + password + '}';
    }
    
}
