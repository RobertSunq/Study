package com.qing.corejavolume.task.xxlJob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * demoXxlJob
 * 分布式任务调度简单示例
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-18 18:22
 * @since: JDK-1.8
 */
public class demoXxlJob {

    private static final Logger logger = LoggerFactory.getLogger(demoXxlJob.class);


    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler(String param) throws Exception {
        XxlJobLogger.log("开始启动定时任务！");
        // 业务调用
        boolean success = StringUtils.isNotBlank(param);
        if (success){
            XxlJobLogger.log("定时任务执行成功！");
            return ReturnT.SUCCESS;
        }
        XxlJobLogger.log("定时任务执行失败！");
        return ReturnT.FAIL;
    }

    public void init() {
        logger.info("init");
    }

    public void destroy() {
        logger.info("destory");
    }
}
