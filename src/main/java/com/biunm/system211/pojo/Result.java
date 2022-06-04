package com.biunm.system211.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *  200请求成功
 *  201账号密码错误
 *  203未登录
 *  204请求失败
 *  205 token过期
 * @param <T>
 */

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
}
