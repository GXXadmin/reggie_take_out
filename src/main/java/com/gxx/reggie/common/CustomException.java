package com.gxx.reggie.common;

/**
 * 自定义业务异常类
 *
 * @author GXX
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
