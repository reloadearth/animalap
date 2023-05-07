package com.nzr.animalap.handler;

import lombok.AllArgsConstructor;

/**
 * 异常枚举类
 */
@AllArgsConstructor
public enum ExceptionEnum implements BaseErrorInfoInterface{
    /**
     * 错误状态码定义
     */
    SUCCESS("2000","成功！"),
    NOT_FOUND("4004","未找到资源！"),
    INTERNAL_SERVER_ERROR("5000","服务器错误！");

    /**
     * 错误码
     */
    private final String resultCode;
    /**
     * 错误信息
     */
    private final String resultMsg;

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
