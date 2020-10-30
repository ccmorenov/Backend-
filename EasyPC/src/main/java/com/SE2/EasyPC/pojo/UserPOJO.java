package com.SE2.EasyPC.pojo;

import com.SE2.EasyPC.dataAccess.model.User;

public class UserPOJO {
    
    private Long idUser;

    private String username;

    public UserPOJO( User user ){
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
    }

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
