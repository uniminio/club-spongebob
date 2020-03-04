package com.kotei.magicconch.clubspongebob.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String email;
    private String nickname;
    private String password;
    private String password2;
}
