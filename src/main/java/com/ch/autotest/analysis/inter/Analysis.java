package com.ch.autotest.analysis.inter;

import com.ch.autotest.body.Inter.iBody;
import org.dom4j.Element;

/**
 * Created by CH on 2017/12/18/018.
 */
public interface Analysis {
    iBody analysis(Element element);
}
