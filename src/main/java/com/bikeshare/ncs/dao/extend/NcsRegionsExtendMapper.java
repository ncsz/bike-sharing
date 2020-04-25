package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.NcsRegions;
import com.bikeshare.ncs.bean.extend.NcsRegionsExtend;

import java.util.List;

public interface NcsRegionsExtendMapper {
    List<NcsRegionsExtend> selectAll();
    List<NcsRegions> findByParentId(long id);
}
