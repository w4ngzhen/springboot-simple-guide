package com.compilemind.guide.chapter03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// 使用注解 @RestController，表明当前类是一个基于REST 规范的HTTP API Controller
@RestController
//@Controller
// @RequestMapping 注解放在Controller上，用于标记 HTTP url的路径入口，
// 例如 http://localhost:8080/hello/xxx 才会进入当前Controller
@RequestMapping("hello")
public class HelloController {

    // @RequestMapping 注解放在Controller的里面的方法上，
    // 将会与Controller上的RequestMapping组合成："/hello/say"
    // method用于指示通过何种HTTP方法访问
    // 在程序启动后，我们可以使用GET方法访问：http://localhost:8080/hello/say
//    @ResponseBody // 如果当前Controller被@Controller注解，又想返回字符串或其他原始数据
    @RequestMapping(value = "say", method = RequestMethod.GET)
    public String say() {
        return "hello, world";
    }

}
