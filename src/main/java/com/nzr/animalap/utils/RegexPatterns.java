package com.nzr.animalap.utils;

/**
 * 正则表达式
 */
public abstract class RegexPatterns{

    /**
     * 邮箱正则
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * 密码正则。6~16位的字母、数字
     */
    public static final String PASSWORD_REGEX = "^\\w{6,16}$";
    /**
     * 验证码正则, 6位数字或字母
     */
    public static final String VERIFY_CODE_REGEX = "^[0-9]{6}$";
}
