package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.bean.NcsHourUsage;
 /**
  * @name NcsHourUsageExtend
  * @date 2020/4/30
  * @author ncs
  * @description 小时使用量拓展
 **/
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
