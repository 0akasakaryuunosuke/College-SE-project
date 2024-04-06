package com.OOZone.entity;
import java.util.Date;
import java.io.Serializable;

public class Comment implements Serializable {
    private static final long serialVersionUID = -1038897351672911219L;
    private Integer commentId;

 /*   private Integer commentPid;
    private String commentPname;
*/
    private Integer commentEssayId;

    private String commentAuthorName;

    private String commentAuthorEmail;

    private String commentAuthorUrl;

    private String commentAuthorAvatar;

    private String commentContent;

    /*private String commentAgent;*/

    private Date commentCreateTime;

    private Integer commentUserId;

}
