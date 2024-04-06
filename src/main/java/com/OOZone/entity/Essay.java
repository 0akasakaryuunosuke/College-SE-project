package com.OOZone.entity;

import java.util.Date;
import java.util.List;

/**
 * 文章实体
 */
public class Essay {
    private Integer essayId;

    private Integer essayUserId;
    private String essayTitle;

    private Integer essayViewCount;

    private Integer essayCommentCount;

    private Integer essayLikeCount;

    private Date essayCreateTime;

    private Date essayUpdateTime;

    private Integer essayIsComment;

    private Integer essayStatus;

    private Integer essayOrder;

    private String essayContent;

    private String essaySummary;

    private String essayThumbnail;

    private User user;

    private List<Tag> tagList;

    private List<Category> categoryList;
}
