package com.course.server.util;

import com.course.server.exception.ValidatorException;
import org.springframework.util.ObjectUtils;

/**
 * @author zzy
 * @date 2022/2/28
 */
public class ValidatorUtil {

    /**
     * 空校验（null or ""）
     */
    public static void require(Object str, String fieldName) {
        if (ObjectUtils.isEmpty(str)) {
            throw new ValidatorException(fieldName + "不能为空");
        }
    }

    /**
     * 长度校验
     */
    public static void length(String str, String fieldName, int min, int max) {
        if (ObjectUtils.isEmpty(str)) {
            return;
        }
        int length = 0;
        if (!ObjectUtils.isEmpty(str)) {
            length = str.length();
        }
        if (length < min || length > max) {
            throw new ValidatorException(fieldName + "长度" + min + "~" + max + "位");
        }
    }
}

