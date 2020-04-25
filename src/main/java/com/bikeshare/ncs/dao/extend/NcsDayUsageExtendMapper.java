package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.extend.NcsDayUsageExtend;
import com.bikeshare.ncs.vm.dayUsage;

import java.util.List;

public interface NcsDayUsageExtendMapper {
    List<NcsDayUsageExtend> selectMonthDataByYear(Long id,String year);
}
