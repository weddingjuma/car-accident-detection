package com.bill.mvc.database.bean;

import javax.persistence.*;

/**
 * Created by chenking on 2017/5/5.
 */
@Entity
@Table(name = "movie", schema = "springmvc", catalog = "")
public class enMovieEntity {
    private int id;
    private String name;
    private int second;
    private int type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "second")
    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        enMovieEntity that = (enMovieEntity) o;

        if (id != that.id) return false;
        if (second != that.second) return false;
        if (type != that.type) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + second;
        result = 31 * result + type;
        return result;
    }
}
