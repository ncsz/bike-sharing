package com.bikeshare.ncs.service.impl;

import com.bikeshare.ncs.bean.NcsDayExample;
import com.bikeshare.ncs.dao.NcsDayMapper;
import com.bikeshare.ncs.dao.extend.NcsDayExtendMapper;
import com.bikeshare.ncs.service.INcsDayService;
import com.bikeshare.ncs.vm.Year;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class NcsDayServiceImpl implements INcsDayService {
    @Resource
    private NcsDayExtendMapper dayExtendMapper;
    @Override
    public List<Year> selectYears() {
        return dayExtendMapper.selectYears();
    }
}
