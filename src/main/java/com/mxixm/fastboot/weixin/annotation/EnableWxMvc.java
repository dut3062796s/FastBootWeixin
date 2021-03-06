/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.mxixm.fastboot.weixin.annotation;

import com.mxixm.fastboot.weixin.config.WxProperties;
import com.mxixm.fastboot.weixin.config.invoker.WxInvokerConfiguration;
import com.mxixm.fastboot.weixin.config.media.WxMediaConfiguration;
import com.mxixm.fastboot.weixin.config.message.WxAsyncMessageConfiguration;
import com.mxixm.fastboot.weixin.config.server.WxBuildinMvcConfiguration;
import com.mxixm.fastboot.weixin.config.server.WxWebConfiguration;
import com.mxixm.fastboot.weixin.config.token.WxTokenConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.*;

/**
 * PropertySource注解不能放在ConfigurationProperties注解上，否则这个注解只对当前类有效，不会写入环境中
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@PropertySource("classpath:/wx.properties")
@EnableConfigurationProperties(WxProperties.class)
@Import({WxInvokerConfiguration.class,
        WxAsyncMessageConfiguration.class,
        WxBuildinMvcConfiguration.class,
        WxTokenConfiguration.class,
        WxMediaConfiguration.class,
        WxWebConfiguration.class})
public @interface EnableWxMvc {

    /**
     * 是否自动创建菜单
     *
     * @return dummy
     */
    boolean menuAutoCreate() default true;

}
