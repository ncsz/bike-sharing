package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.vm.Year;

import java.util.List;

public interface NcsDayExtendMapper {
    List<Year> selectYears();
}
