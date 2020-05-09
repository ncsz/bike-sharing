package com.bikeshare.ncs.service.impl;

import com.bikeshare.ncs.bean.NcsRegions;
import com.bikeshare.ncs.bean.NcsRegionsExample;
import com.bikeshare.ncs.bean.extend.NcsRegionsExtend;
import com.bikeshare.ncs.dao.NcsRegionsMapper;
import com.bikeshare.ncs.dao.extend.NcsRegionsExtendMapper;
import com.bikeshare.ncs.service.INcsRegionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;
 /**
  * @name NcsRegionsServiceImpl
  * @date 2020/4/30
  * @author ncs
  * @description 区域实现类
 **/
@Service
public class NcsRegionsServiceImpl implements INcsRegionsService {
    @Resource
    private NcsRegionsMapper regionsMapper;
    @Resource
    private NcsRegionsExtendMapper regionsExtendMapper;
    @Override
    public List<NcsRegions> findAll() {
        NcsRegionsExample regionsExample=new NcsRegionsExample();
        regionsExample.createCriteria().andLevelEqualTo(1);
        return regionsMapper.selectByExample(regionsExample);
    }

    @Override
    public List<NcsRegionsExtend> selectAll() {
        return regionsExtendMapper.selectAll();
    }
}
