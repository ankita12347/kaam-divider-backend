package com.ljprojects.kaam_divider.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "users") // if table name is diff than the entity class, mandatory to write
                        // @Entity(name="<table name>")
public class Users {
    @Id
    private Long id;
    @Column(name = "name") // non mandatory if name matches with table
    private String name;
    @Column(name = "password") // non mandatory if name matches with table
    private String password;

    public Users() {

    }

    public Users(Long id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", name=" + name + ", password=" + password + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
