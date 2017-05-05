package com.billwork.mvc.POJO;

import java.io.Serializable;

/**
 * Created by chenking on 2017/5/5.
 */

public class Message implements Serializable {
    private String name;
    private Integer status;
    private String Description;
    private String Object;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getObject() {
        return Object;
    }

    public void setObject(String object) {
        Object = object;
    }
}
