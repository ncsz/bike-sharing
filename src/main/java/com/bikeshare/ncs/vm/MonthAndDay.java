package com.bikeshare.ncs.vm;

import java.util.List;

public class MonthAndDay {
    String year;
    List<Day> children;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Day> getChildren() {
        return children;
    }

    public void setChildren(List<Day> children) {
        this.children = children;
    }
}
