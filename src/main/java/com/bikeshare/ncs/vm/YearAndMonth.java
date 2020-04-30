package com.bikeshare.ncs.vm;

import com.bikeshare.ncs.bean.NcsDay;
import com.sun.xml.internal.ws.developer.Serialization;

import java.util.List;
@Serialization
public class YearAndMonth {
    String year;
    List<Month> children;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Month> getChildren() {
        return children;
    }

    public void setChildren(List<Month> children) {
        this.children = children;
    }
}
