package com.SE2.EasyPC.pojo;

public class UserPOJO {
    
    private Long idUser;

    private String username;

    private String password;

    public Long getIdUser() {//idUser getter
        return idUser;
    }

    public void setIdUser(Long idUser) {//idUser setter
        this.idUser = idUser;
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
