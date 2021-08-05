package com.compilemind.guide.chapter00.manual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 放在类型上
@Retention(RetentionPolicy.RUNTIME) // 运行时保留
public @interface UserInfo {

    String name();

    int age();
}
