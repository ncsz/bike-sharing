package com.bikeshare.ncs.service;

import com.bikeshare.ncs.vm.Year;

import java.util.List;

public interface INcsDayService {
    List<Year> selectYears();
}
