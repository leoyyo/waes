package com.waes.web.scalable.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class for Left and Right data
 */
@Entity
public class LeftRightData {

    @Id
    private Integer id;

    private String left;

    private String right;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

}
