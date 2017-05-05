package com.bill.mvc.POJO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenking on 2017/5/5.
 */

public class Message<T> implements Serializable {
    private String name;
    private Integer status;
    private String Description;
    private List<T> Object;

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

    public List<T> getObject() {
        return Object;
    }

    public void setObject(List<T> object) {
        Object = object;
    }
}
