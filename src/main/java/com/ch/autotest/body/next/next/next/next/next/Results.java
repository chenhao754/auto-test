package com.ch.autotest.body.next.next.next.next.next;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @descritpion api返回值，也就是result对应的实体类
 */
public class Results implements iBody {
    List<iBody> resultList;

    public List<iBody> getResultList() {
        return resultList;
    }

    public void setResultList(List<iBody> resultList) {
        this.resultList = resultList;
    }
}
