package com.bikeshare.ncs.service.impl;

import com.bikeshare.ncs.bean.Test;
import com.bikeshare.ncs.bean.TestExample;
import com.bikeshare.ncs.dao.TestMapper;
import com.bikeshare.ncs.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
 /**
  * @name TestServiceImpl
  * @date 2020/4/30
  * @author ncs
  * @description 测试类实现类
 **/
@Service
public class TestServiceImpl implements ITestService {
    @Resource
    private TestMapper testMapper;
    @Override
    public List<Test> findAll(){
        TestExample testExample=new TestExample();
        List<Test> list=testMapper.selectByExample(testExample);
        return list;
    }
    public void saveOrUpdate(Test test){
        testMapper.insert(test);
    }
}
