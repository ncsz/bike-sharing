package com.bikeshare.ncs.vm;
 /**
  * @name Day
  * @date 2020/4/30
  * @author ncs
  * @description 天类，前端用cascader级联机制自动填充，故设置属性都为year，本意为天
 **/
public class Day {
    Long id;
    String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
