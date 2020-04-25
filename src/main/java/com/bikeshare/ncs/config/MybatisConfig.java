package com.bikeshare.ncs.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bikeshare.ncs.dao")
public class MybatisConfig {
}
