package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.bean.NcsHourUsage;

public class NcsHourUsageExtend extends NcsHourUsage {
    private NcsDay day;

    public NcsDay getDay() {
        return day;
    }

    public void setDay(NcsDay day) {
        this.day = day;
    }
}
