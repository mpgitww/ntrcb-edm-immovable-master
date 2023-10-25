package com.ntrcb.common.exception;


/**
 * @author 01061698
 * @Description: 服务异常
 * @date 2022/7/29 14:36
 */
public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
