package com.floxcat.hooklinspirer.utils;

import java.io.Serializable;


public class ItemApp implements Serializable {
    private boolean canuninstall;
    private int exception_white_url;
    private int hide_icon_status;
    private long id;
    private boolean is_trust;
    private boolean isforce;
    private boolean isnew;
    private String md5sum;
    private String packagename;
    private String path;
    private String sha1;
    private int status;
    private String updated_at;
    private int versioncode;
    private String versionname;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public boolean isIsnew() {
        return this.isnew;
    }

    public void setIsnew(boolean z) {
        this.isnew = z;
    }

    public int getException_white_url() {
        return this.exception_white_url;
    }

    public void setException_white_url(int i) {
        this.exception_white_url = i;
    }

    public boolean isIs_trust() {
        return this.is_trust;
    }

    public void setIs_trust(boolean z) {
        this.is_trust = z;
    }

    public int getHide_icon_status() {
        return this.hide_icon_status;
    }

    public void setHide_icon_status(int i) {
        this.hide_icon_status = i;
    }

    public String getPackagename() {
        return this.packagename;
    }

    public void setPackagename(String str) {
        this.packagename = str;
    }

    public String getVersionname() {
        return this.versionname;
    }

    public void setVersionname(String str) {
        this.versionname = str;
    }

    public int getVersioncode() {
        return this.versioncode;
    }

    public void setVersioncode(int i) {
        this.versioncode = i;
    }

    public boolean isIsforce() {
        return this.isforce;
    }

    public void setIsforce(boolean z) {
        this.isforce = z;
    }

    public boolean isCanuninstall() {
        return this.canuninstall;
    }

    public void setCanuninstall(boolean z) {
        this.canuninstall = z;
    }

    public String getSha1() {
        return this.sha1;
    }

    public void setSha1(String str) {
        this.sha1 = str;
    }

    public String getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getMd5sum() {
        return this.md5sum;
    }

    public void setMd5sum(String str) {
        this.md5sum = str;
    }
}