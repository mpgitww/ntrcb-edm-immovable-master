package com.ntrcb.common.service.imp;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.ntrcb.common.entity.ApiLogEntity;
import com.ntrcb.common.mapper.IApiLogMapper;
import com.ntrcb.common.service.IApiLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApiLogServiceImpl implements IApiLogService {
    @Resource
    private IApiLogMapper apiLogMapper;

    @Override
    public void save(ApiLogEntity entity) {
        apiLogMapper.insert(entity);
    }
}
