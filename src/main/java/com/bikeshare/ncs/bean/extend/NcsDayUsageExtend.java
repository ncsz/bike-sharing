package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.bean.NcsDayUsage;

public class NcsDayUsageExtend extends NcsDayUsage {
    private NcsDay days;
    private String month;
    private Long id;
    private String day;
    private String holiday;

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

    public NcsDay getDays() {
        return days;
    }

    public void setDays(NcsDay days) {
        this.days = days;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }
}
