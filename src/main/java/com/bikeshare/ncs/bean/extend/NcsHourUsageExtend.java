package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.bean.NcsHourUsage;

public class NcsHourUsageExtend extends NcsHourUsage {
    private NcsDay days;
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public NcsDay getDays() {
        return days;
    }

    public void setDays(NcsDay days) {
        this.days = days;
    }
}
