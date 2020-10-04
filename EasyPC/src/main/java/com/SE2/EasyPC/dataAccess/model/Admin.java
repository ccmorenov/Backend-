package com.SE2.EasyPC.dataAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table( name = "Admin" )
public class Admin {//Admin class definition
    @Column(name = "id_admin")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    @Column
    private String username;

    @Column
    private String password;

    public Long getIdAdmin() {//idAdmin getter
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {//idAmin setter
        this.idAdmin = idAdmin;
    }

    public String getUsername() {//username getter
        return username;
    }

    public void setUsername(String username) {//username setter
        this.username = username;
    }

    public String getPassword() {//password getter
        return password;
    }

    public void setPassword(String password) {//password setter
        this.password = password;
    }

}
