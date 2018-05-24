package com.hwy.anno;

import java.lang.annotation.*;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface Idempotent {

    /**
     * 定义幂等性key值的前缀值，用于区别不同的业务
     */
    String previous() default "";

    /**
     * 过期时间，默认60秒
     */
    int expiredTime() default 60;

}
