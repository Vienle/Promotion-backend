package com.cirlcek.promotion.dtos;

public class UserDto {
    private String staffcode;
    private String password;

    public UserDto() {
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
