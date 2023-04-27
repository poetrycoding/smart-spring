package com.github.poetrycoding.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description: 系统文件加载器
 * <br/>
 * FileSystemResource
 *
 * @author laiql
 * @date 2023/4/27 21:03
 */
public class FileSystemResource implements Resource {
    private final File file;

    private final String path;

    public FileSystemResource(File file, String path) {
        this.file = file;
        this.path = path;
    }

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }
}
