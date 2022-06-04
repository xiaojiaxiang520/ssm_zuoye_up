package com.biunm.system211.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {
    private Integer CourseId;
    private String Name;
    private Integer Count;
    private Integer Download;
    private Boolean State;//true表示显示，false表示不显示，默认为true
    private String NewTime;
    private Boolean CourseState;//true表示显示（不删除），false表示删除，默认为true
    private Integer Limit;
}
