package com.ch.autotest.body.next.next.next.next.next.next;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;

/**
 * Created by CH on 2017/12/19/019.
 */
public class Body implements iBody {
    List<iBody> paramList;

    public List<iBody> getParamList() {
        return paramList;
    }

    public void setParamList(List<iBody> paramList) {
        this.paramList = paramList;
    }
}
