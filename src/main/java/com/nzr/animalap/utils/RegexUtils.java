package com.nzr.animalap.utils;

import cn.hutool.core.util.StrUtil;

public class RegexUtils extends RegexPatterns{

    /**
     * 是否为邮箱格式
     * @param email
     * @return
     */
    public static boolean isEmailInvalid(String email){
        return mismatch(email,RegexPatterns.EMAIL_REGEX);
    }

    /**
     * 是否为密码格式
     * @param password
     * @return
     */
    public static boolean isPasswordInvalid(String password){
        return mismatch(password,RegexPatterns.PASSWORD_REGEX);
    }

    /**
     * 是否为验证码格式
     * @param vcode
     * @return
     */
    public static boolean isVcodeInvalid(String vcode){
        return mismatch(vcode,RegexPatterns.VERIFY_CODE_REGEX);
    }

    /**
     * 校验是否符合正则格式
     * @param str
     * @param regex
     * @return true符合 false不符合
     */
    private static boolean mismatch(String str, String regex){
        if (StrUtil.isBlank(str)) {
            return true;
        }
        return !str.matches(regex);
    }
}
