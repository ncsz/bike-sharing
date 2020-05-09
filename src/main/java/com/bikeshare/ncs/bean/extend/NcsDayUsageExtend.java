package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.bean.NcsDayUsage;
 /**
  * @name NcsDayUsageExtend
  * @date 2020/4/30
  * @author ncs
  * @description 天使用量bean拓展
 **/
public class NcsDayUsageExtend extends NcsDayUsage {
    private NcsDay days;
    private String month;
    private Long id;
    private String day;
    private String holiday;
    private String tem;

     public String getTem() {
         return tem;
     }

     public void setTem(String tem) {
         this.tem = tem;
     }

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
