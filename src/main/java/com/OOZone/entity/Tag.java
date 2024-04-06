package com.OOZone.entity;

import java.io.Serializable;

public class Tag implements Serializable {
    /*数据库字段*/
    private Integer tagId;

    private String tagName;

    private String tagDescription;
    /*非数据库字段*/
    private Integer essayCount;

    public Tag() {
    }
    public Tag(Integer tagId) {
        this.tagId = tagId;
    }

    public Tag(Integer tagId, String tagName, String tagDescription, Integer essayCount) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
        this.essayCount = essayCount;
    }
}
