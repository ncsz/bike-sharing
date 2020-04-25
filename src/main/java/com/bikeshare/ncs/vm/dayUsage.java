package com.bikeshare.ncs.vm;

public class dayUsage {
    private String month;
    private Long registerData;
    private Long unRegisterData;
    private Long totalData;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getRegisterData() {
        return registerData;
    }

    public void setRegisterData(Long registerData) {
        this.registerData = registerData;
    }

    public Long getUnRegisterData() {
        return unRegisterData;
    }

    public void setUnRegisterData(Long unRegisterData) {
        this.unRegisterData = unRegisterData;
    }

    public Long getTotalData() {
        return totalData;
    }

    public void setTotalData(Long totalData) {
        this.totalData = totalData;
    }
}
