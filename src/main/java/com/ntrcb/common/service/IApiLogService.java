package com.ntrcb.common.service;


import com.ntrcb.common.entity.ApiLogEntity;

public interface IApiLogService {
    /**
     * 保存api日志
     *
     * @param entity
     */
    void save(ApiLogEntity entity);
}
