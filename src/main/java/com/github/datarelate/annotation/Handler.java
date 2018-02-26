package com.github.datarelate.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
@Inherited
public @interface Handler {
    
    /**
     * 根据该值进行handler的判断便于判断需要执行哪些handler
     * 暂定默认值为handler的完整名（即该值不填写时）
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @return <br>
     */
    String value() default "";

}
