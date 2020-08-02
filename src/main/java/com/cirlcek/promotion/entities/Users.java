package com.cirlcek.promotion.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Users {
    @Id
    private long id;
    private String staffcode;
    private String password;
    private int status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
    private List<Credentials> credentialsList;

    public Users() {
        this.id = Calendar.getInstance().getTimeInMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Credentials> getCredentialsList() {
        if (this.credentialsList.size() == 0 || this.credentialsList == null){
            this.credentialsList = new ArrayList<>();
        }
        return credentialsList;
    }

    public void setCredentialsList(List<Credentials> credentialsList) {
        this.credentialsList = credentialsList;
    }
    public void setCredentialsList(Credentials credentials) {
        this.credentialsList = credentialsList;
        credentials.setUser(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
