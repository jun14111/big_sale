package com.model;

import java.io.Serializable;
import lombok.Data;

/**
 * userinfo
 * @author 
 */
@Data
public class Userinfo implements Serializable {
    private Integer userid;

    private String username;

    private String password;

    private String realname;

    private static final long serialVersionUID = 1L;
}