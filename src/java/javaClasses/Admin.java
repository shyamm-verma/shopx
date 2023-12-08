/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaClasses;

/**
 *
 * @author raj94
 */
public class Admin {
    private int adm_id;
    private String name;
    private String email;
    private String password;

    public Admin() {
    }

    public Admin(int adm_id, String name, String email, String password) {
        this.adm_id = adm_id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getAdm_id() {
        return adm_id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setAdm_id(int adm_id) {
        this.adm_id = adm_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "adm_id=" + adm_id + ", name=" + name + ", email=" + email + ", password=" + password + '}';
    }
    
    
}
