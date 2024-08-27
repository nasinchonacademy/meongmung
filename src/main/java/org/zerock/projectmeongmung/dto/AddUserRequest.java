package org.zerock.projectmeongmung.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@Data
public class AddUserRequest {
    private String uid;
    private String nickname;
    private String email;
    private String password;
    private String name;
    private String dogname;
    private String dogbreed;
    private MultipartFile profilePhoto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dogbirthday;
    private String dogmeeting;
    private boolean marketsns;
    private boolean locservice;
    private boolean term_use;
    private boolean personalinfo;
    private int jellypoint;
}
