package com.ch.autotest.body.next.next.next.next;

import com.ch.autotest.body.Inter.iBody;

/**
 * Created by CH on 2017/12/25/025.
 */
public class Select implements iBody{
    private iBody params;
    private iBody results;

    public iBody getParams() {
        return params;
    }

    public void setParams(iBody params) {
        this.params = params;
    }

    public iBody getResults() {
        return results;
    }

    public void setResults(iBody results) {
        this.results = results;
    }
}
