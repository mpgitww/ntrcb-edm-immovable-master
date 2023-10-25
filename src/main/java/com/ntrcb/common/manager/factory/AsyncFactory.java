package com.ntrcb.common.manager.factory;


import com.hb0730.commons.spring.SpringContextUtils;
import com.ntrcb.common.entity.ApiLogEntity;
import com.ntrcb.common.service.IApiLogService;
import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author bing_huang
 * @since 3.0.0
 */
@Slf4j
public class AsyncFactory {
    /**
     * 记录接口日志
     *
     * @param entity 接口日志
     * @return {@link TimerTask}
     */
    public static TimerTask recordApiLog(ApiLogEntity entity) {
        return new TimerTask() {
            @Override
            public void run() {
                SpringContextUtils.getBean(IApiLogService.class).save(entity);
            }
        };
    }
}
