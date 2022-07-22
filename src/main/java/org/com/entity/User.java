package org.com.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class User extends AbstractEntity {
    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "authority", nullable = false)
    private String authority;

    @Column(name = "mail", nullable = false)
    private String mail;

    public User() {
    }

    public User(String username, String password, String authority, String mail) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.mail = mail;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "[ID: " + id +
                ", username: " + username + "]";
    }
}
