package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.NcsRegions;

import java.util.List;
 /**
  * @name NcsRegionsExtend
  * @date 2020/4/30
  * @author ncs
  * @description 区域bean拓展
 **/
public class NcsRegionsExtend extends NcsRegions {
    private List<NcsRegions> children;

    public List<NcsRegions> getChildren() {
        return children;
    }

    public void setChildren(List<NcsRegions> children) {
        this.children = children;
    }
}
