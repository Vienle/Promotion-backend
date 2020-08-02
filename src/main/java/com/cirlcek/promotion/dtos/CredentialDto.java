package com.cirlcek.promotion.dtos;

import com.cirlcek.promotion.entities.Credentials;

public class CredentialDto {
    private String acessToken;
    private String refreshToken;
    private long expireTime;
    private long createDate;
    private long updateDate;
    private int status;

    public CredentialDto() {
    }

    public CredentialDto(Credentials cr) {
        this.acessToken = cr.getAcessToken();
        this.refreshToken = cr.getRefreshToken();
        this.expireTime = cr.getExpireTime();
        this.createDate = cr.getCreateDate();
        this.updateDate = cr.getUpdateDate();
        this.status = cr.getStatus();
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
