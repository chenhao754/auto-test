package com.ch.autotest.body.next.next.next.next.next.next;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;
import java.util.Map;

/**
 * Created by CH on 2017/12/18/018.
 * @descritpion API访问的单个参数实体类
 */
public class Param implements iBody {
    String key;
    String value;
    iBody list;
    iBody map;
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public iBody getList() {
        return list;
    }

    public void setList(iBody list) {
        this.list = list;
    }

    public iBody getMap() {
        return map;
    }

    public void setMap(iBody map) {
        this.map = map;
    }
}
