package com.imooc.ad.index;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据数据表导出的文件，读取文件，加载索引
 */
@Slf4j
@Component
@DependsOn("dataTable")
public class IndexFileLoader {

    /**
     * 读取数据文件，转换成一行一行的数据
     */
    private List<String> loadDumpData(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(
                Paths.get(fileName)
        )) {
            return br.lines().collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
