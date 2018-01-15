package com.ch.autotest.body;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 */
public class Auto implements iBody {
    List<iBody> beansList;
    List<iBody> importList;

    public List<iBody> getBeansList() {
        return beansList;
    }

    public void setBeansList(List<iBody> beansList) {
        this.beansList = beansList;
    }

    public List<iBody> getImportList() {
        return importList;
    }

    public void setImportList(List<iBody> importList) {
        this.importList = importList;
    }
}
