package com.ch.autotest.body.next.next.next.next.next.next.next;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;

/**
 * Created by CH on 2018/1/8/008.
 */
public class iList implements iBody {
    List<String> iList;

    public List<String> getiList() {
        return iList;
    }

    public void setiList(List<String> iList) {
        this.iList = iList;
    }
}
