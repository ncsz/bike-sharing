package com.bikeshare.ncs.vm;

import com.sun.xml.internal.ws.developer.Serialization;

import java.util.List;

@Serialization
public class YearMonthAndDay {
    String year;
    List<MonthAndDay> children;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<MonthAndDay> getChildren() {
        return children;
    }

    public void setChildren(List<MonthAndDay> children) {
        this.children = children;
    }
}
