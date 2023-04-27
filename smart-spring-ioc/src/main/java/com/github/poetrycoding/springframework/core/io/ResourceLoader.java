package com.github.poetrycoding.springframework.core.io;

/**
 * Description: 资源加载器
 * <br/>
 * ResourceLoader
 *
 * @author laiql
 * @date 2023/4/27 20:53
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 根据路径加载资源
     *
     * @param location 资源路径
     * @return 返回资源对象
     */
    Resource getResource(String location);

}
