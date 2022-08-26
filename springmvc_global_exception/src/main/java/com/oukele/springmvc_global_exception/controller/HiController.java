package com.oukele.springmvc_global_exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oukele
 */
@RestController
@RequestMapping(path = "/hi")
public class HiController {

    /**
     * 抛出除数不能为0的异常
     *
     * @return
     */
    @GetMapping(path = "/1")
    public String one() {
        int i = 10 / 0;
        return "success";
    }

    /**
     * controller再手动进行往上抛出异常
     *
     * @return
     */
    @GetMapping(path = "/2")
    public String two() throws Exception {
        throw new Exception("controller手动抛出异常");
    }


    /**
     * 模拟没进入方法前就出现异常的情况，
     *
     * @return
     */
    @GetMapping(path = "/3")
    public String three(@RequestParam("name") String name) {
        return name + " - success";
    }

}
