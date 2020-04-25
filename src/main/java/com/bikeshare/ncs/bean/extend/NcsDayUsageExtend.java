package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.bean.NcsDayUsage;

public class NcsDayUsageExtend extends NcsDayUsage {
    private NcsDay day;
    private String month;
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public NcsDay getDay() {
        return day;
    }

    public void setDay(NcsDay day) {
        this.day = day;
    }
}
