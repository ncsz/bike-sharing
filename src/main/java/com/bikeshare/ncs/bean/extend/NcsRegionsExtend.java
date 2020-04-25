package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.NcsRegions;

import java.util.List;

public class NcsRegionsExtend extends NcsRegions {
    private List<NcsRegions> children;

    public List<NcsRegions> getChildren() {
        return children;
    }

    public void setChildren(List<NcsRegions> children) {
        this.children = children;
    }
}
