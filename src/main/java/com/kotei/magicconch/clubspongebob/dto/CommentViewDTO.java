package com.kotei.magicconch.clubspongebob.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentViewDTO {
    private int admin_id;
    private Date comm_time;
    private String comm_nickname;
    private String comm_content;
    private String head_img;
}
