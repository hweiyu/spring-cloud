package com.hwy.aspect;

import com.hwy.anno.Idempotent;
import com.hwy.cons.Cons;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/24 14:25
 **/
@Aspect
@Component
public class IdempotentAspect {

    @Around("@annotation(idemp)")
    public Object idempCheck(ProceedingJoinPoint point, Idempotent idemp){
        try {
            Message message = null;
            for (Object arg : point.getArgs()) {
                if (arg instanceof Message) {
                    message = (Message) arg;
                }
            }
            if (null != message) {
                Object uniqueIdentity = message.getHeaders().get(Cons.UNIQUE_IDENTITY);
                if (null != uniqueIdentity) {
                    System.out.println("====== from idem aspect, todo idempotent check current version is : " + uniqueIdentity);
                    //todo idempotent check
                    return null;
                }
            }
            return point.proceed();
        } catch (Throwable e) {
            e.printStackTrace ();
        }
        return null;
    }
}
