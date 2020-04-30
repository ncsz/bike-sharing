package com.bikeshare.ncs.service;

import com.bikeshare.ncs.vm.Day;
import com.bikeshare.ncs.vm.Year;
import com.bikeshare.ncs.vm.YearAndMonth;
import com.bikeshare.ncs.vm.YearMonthAndDay;

import java.util.List;

public interface INcsDayService {
    List<Year> selectYears();
    List<YearAndMonth> selectYearsAndMonths();
    List<YearMonthAndDay> selectYearsMonthsAndDays();
}
