package com.stylefeng.guns.gateway.common;

/**
 * 用户信息保存ThreadLocal（把ThreadLocal当session）
 *
 * @author Michael.Chu
 * @date 2019-03-18 21:44
 */
public class CurrentUser {

    /**
     * 线程绑定的存储空间
     */
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 将userId保存进存储空间
     * @param userId {@link String} userId
     */
    public static void saveUserInfo(String userId) {
        THREAD_LOCAL.set(userId);
    }

    /**
     * 获取userId
     * @return {@link String} userId
     */
    public static String getCurrentUser() {
        return THREAD_LOCAL.get();
    }
}
