package com.medcine.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wkq
 * @date 2020/11/19 16:52
 */

@Component
public class WebMvcConfig extends  WebMvcConfigurerAdapter {
    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //上传的图片在D盘下的/image目录下，访问路径如
        //其中pathPatterns表示访问的前缀。"file:D://image/"是文件真实的存储路径
        registry.addResourceHandler("/**").addResourceLocations("file:D://zzj//images/")
                .addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
        //file:D://image//指向本地图片路径地址
        super.addResourceHandlers(registry);
    }

}
