package com.compilemind.guide.chapter00.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameEx {

    private UserEx userEx;

    @Autowired // 使用注解 @Autowired，表明希望IOC容器为我们注入这个UserEx的实例
    public void setUserEx(UserEx userEx) {
        this.userEx = userEx;
        System.out.println("调用setUserEx");
    }

    /**
     * 打印GameEx的UserEx
     */
    public void printUserEx() {
        if (this.userEx == null) {
            System.out.println("无用户");
        } else {
            System.out.println(this.userEx);
        }
    }

}
