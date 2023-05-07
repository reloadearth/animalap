package com.nzr.animalap.handler;

/**
 * 错误信息接口
 */
public interface BaseErrorInfoInterface {

    /**
     * 错误码
     */
    String getResultCode();

    /**
     * 错误原因
     */
    String getResultMsg();
}
