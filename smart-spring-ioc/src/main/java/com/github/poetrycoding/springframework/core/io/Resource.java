package com.github.poetrycoding.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description: 操作资源接口定义
 * <br/>
 * Resource
 *
 * @author laiql
 * @date 2023/4/27 20:49
 */
public interface Resource {

    /**
     * 读取资源接口
     *
     * @return 返回资源流
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
