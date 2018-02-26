package com.github.datarelate.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface HandlerScan {

    /**
     * handler 扫描包配置
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @return <br>
     */
    String[] value() default {};

}
