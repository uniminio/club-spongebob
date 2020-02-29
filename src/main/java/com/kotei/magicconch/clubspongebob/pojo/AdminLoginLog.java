package com.kotei.magicconch.clubspongebob.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class AdminLoginLog {
    private int log_id;
    private int admin_id;
    private Date login_time;
    private String login_ip;
}
