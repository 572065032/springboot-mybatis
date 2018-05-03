package com.buchou.domain.user;

import com.buchou.domain.other.BaseEntity;
import com.buchou.util.StringUtil;

import java.io.Serializable;

public class User extends BaseEntity  {


    private Long id;

    private String username;

    private String password;

    private String phone;

    private String idcard;

    private String code;

    public User() {
    }

    public User(String username, String password, String phone, String idcard) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.idcard = idcard;
    }

    public User(String username, String password) throws Exception {
        if(StringUtil.isEmpty(username)){
            throw new Exception("1001");
        }else{
            this.username = username;
        }
        if(StringUtil.isEmpty(password)){
            throw new Exception("1002");
        }else{
            this.password = password;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
