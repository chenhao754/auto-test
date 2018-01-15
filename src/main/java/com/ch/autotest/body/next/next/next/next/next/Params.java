package com.ch.autotest.body.next.next.next.next.next;

import com.ch.autotest.body.Inter.iBody;

import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @description API访问参数的实体类总体
 */
public class Params implements iBody {
    List<iBody> paramList;
    List<iBody> bodyList;
    List<iBody> headerList;

    public List<iBody> getParamList() {
        return paramList;
    }

    public void setParamList(List<iBody> paramList) {
        this.paramList = paramList;
    }

    public List<iBody> getBodyList() {
        return bodyList;
    }

    public void setBodyList(List<iBody> bodyList) {
        this.bodyList = bodyList;
    }

    public List<iBody> getHeaderList() {
        return headerList;
    }

    public void setHeaderList(List<iBody> headerList) {
        this.headerList = headerList;
    }
}
