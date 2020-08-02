package com.cirlcek.promotion.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Credentials {
    @Id
    private String acessToken;
    private String refreshToken;
    private long expireTime;
    private long createDate;
    private long updateDate;
    private int status;

    @ManyToOne
    private Users user;

    public Credentials() {
        this.acessToken = UUID.randomUUID().toString();
        this.createDate =  Calendar.getInstance().getTimeInMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE,1);
        this.expireTime = calendar.getTimeInMillis();
        this.status = credentialStatus.ACTIVE.values;

    }

    public enum credentialStatus{
        ACTIVE(1),DEACTIVE(0);
        private int values;

        credentialStatus(int values) {
            this.values = values;
        }

        public int getValues() {
            return values;
        }

        public void setValues(int values) {
            this.values = values;
        }
    }

    public Users getUser() {
        if (user == null){
            user = new Users();
        }
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
