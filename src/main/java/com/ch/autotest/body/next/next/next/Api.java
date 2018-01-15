package com.ch.autotest.body.next.next.next;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @description api对应的实体类
 */
public class Api implements iBody {
    String mail;
    String url;
    String type;
    List<iBody> selectList;
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<iBody> getSelectList() {
        return selectList;
    }

    public void setSelectList(List<iBody> selectList) {
        this.selectList = selectList;
    }
}
