package com.bikeshare.ncs.service;

import com.bikeshare.ncs.bean.Test;

import java.util.List;

public interface ITestService {
    List<Test> findAll();
    void saveOrUpdate(Test test);
}
