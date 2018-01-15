package com.ch.autotest.body.next.next;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @description Bean对应的实体类
 */
public class Bean implements iBody {
    String mail;
    String name;
    List<iBody> apiList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<iBody> getApiList() {
        return apiList;
    }

    public void setApiList(List<iBody> apiList) {
        this.apiList = apiList;
    }
}
