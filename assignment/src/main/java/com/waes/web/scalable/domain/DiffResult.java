package com.waes.web.scalable.domain;

import com.waes.web.scalable.enums.DataDiff;
import com.waes.web.scalable.persistence.LeftRightData;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiffResult {

    private LeftRightData leftRightData;
    private String result;

    public LeftRightData getLeftRightData() {
        return leftRightData;
    }

    public void setLeftRightData(LeftRightData leftRightData) {
        this.leftRightData = leftRightData;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
