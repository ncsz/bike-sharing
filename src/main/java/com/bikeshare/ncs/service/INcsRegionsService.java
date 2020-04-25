package com.bikeshare.ncs.service;

import com.bikeshare.ncs.bean.NcsRegions;
import com.bikeshare.ncs.bean.NcsRegionsExample;
import com.bikeshare.ncs.bean.extend.NcsRegionsExtend;

import javax.annotation.Resource;
import java.util.List;

public interface INcsRegionsService {
    List<NcsRegions> findAll();
    List<NcsRegionsExtend> selectAll();
}
