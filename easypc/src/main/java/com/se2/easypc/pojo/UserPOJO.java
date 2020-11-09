package com.se2.easypc.pojo;

import com.se2.easypc.data_access.model.User;

public class UserPOJO {
    
    private Long idUser;

    private String username;

    public UserPOJO( User user ){
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
    }

    public UserPOJO() {}

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

}
