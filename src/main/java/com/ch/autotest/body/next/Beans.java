package com.ch.autotest.body.next;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @description beans对应的实体类
 */
public class Beans implements iBody {
    String mail;
    List<iBody> beanList;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<iBody> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<iBody> beanList) {
        this.beanList = beanList;
    }
}
