package com.biunm.system211.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TaskMultipartFile {
    private Task task;
    private MultipartFile file;
}
