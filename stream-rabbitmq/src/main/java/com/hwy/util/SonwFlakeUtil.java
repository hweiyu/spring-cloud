package com.hwy.util;

/**
 * 全局唯一id发号器
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/25 9:58
 **/
public class SonwFlakeUtil {

    private static volatile SnowFlake snowFlake;

    private static SnowFlake getSnowFlake() {
        if (snowFlake == null) {
            synchronized (SonwFlakeUtil.class) {
                if (snowFlake == null) {
                    snowFlake = new SnowFlake(1, 1);
                }
            }
        }
        return snowFlake;
    }

    public static long getUniqueIdentity() {
        return getSnowFlake().nextId();
    }

    public static void main(String[] args) {
        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(getUniqueIdentity());
        }

    }
}
