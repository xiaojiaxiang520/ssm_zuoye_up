package com.biunm.system211.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Task implements Serializable {
    private int TaskId;
    private String TaskName;
    private String TaskUrl;
    private String CourseName;
    private int Download;
    private Boolean TaskState;//true表示显示，false表示不显示
    private Boolean TaskDelete;
    private int CourseId;
    private String newTime;
    private int Limit;
}
