package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.vm.*;

import java.util.List;
 /**
  * @name NcsDayExtendMapper
  * @date 2020/4/30
  * @author ncs
  * @description  天mapper扩展
 **/
public interface NcsDayExtendMapper {
    List<Year> selectYears();
    List<YearAndMonth> selectYearsAndMonths();
    List<NcsDay> selectByYear();
    List<Day> selectDays(String year,String month);
}
