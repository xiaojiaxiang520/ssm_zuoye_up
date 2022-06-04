package com.biunm.system211.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer Userid;
    private String Username;
    private String Password;
    private Integer Activety;
    private String Email;
}
