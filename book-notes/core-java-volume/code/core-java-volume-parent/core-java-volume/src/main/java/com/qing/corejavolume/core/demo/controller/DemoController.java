package com.qing.corejavolume.core.demo.controller;

import com.qing.corejavolume.core.demo.domain.DemoEntity;
import com.qing.corejavolume.core.demo.domain.mapping.DemoEntityMapping;
import com.qing.corejavolume.core.demo.domain.vo.DemoEntityVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * DemoController
 * 控制层  示例
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-21 19:08
 * @since: JDK-1.8
 */

@Controller
@Slf4j
@RequestMapping("/core/demo")
public class DemoController {

    @Resource
    private DemoEntityMapping demoEntityMapping;

    /**
     * demo
     * @param demoEntityVo demoEntityVo
     * @return "111"
     */
    @PostMapping("/testDemo")
    @ResponseBody
    public String demo(@RequestBody DemoEntityVo demoEntityVo) {
        DemoEntity demoEntity = demoEntityMapping.toEntity(demoEntityVo);
        System.out.println(demoEntity);
        return  "111";
    }

    /**
     * 测试请求参数
     * @param request request
     * @return "222"
     */
    @PostMapping("/testParam")
    @ResponseBody
    public String demo(HttpServletRequest request) {
        System.out.println(request.getParameterMap());
        return  "222";
    }
}
