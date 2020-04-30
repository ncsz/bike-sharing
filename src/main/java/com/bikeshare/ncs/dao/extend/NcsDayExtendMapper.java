package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.vm.*;

import java.util.List;

public interface NcsDayExtendMapper {
    List<Year> selectYears();
    List<YearAndMonth> selectYearsAndMonths();
    List<NcsDay> selectByYear();
    List<Day> selectDays(String year,String month);
}
