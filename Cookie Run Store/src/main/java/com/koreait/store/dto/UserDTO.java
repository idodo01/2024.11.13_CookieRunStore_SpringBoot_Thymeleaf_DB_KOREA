package com.koreait.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO { // join.html에서 name으로 넘어온 것들이 여기에 각각 들어감
    private String id;
    private String password;
    private String tel;
    private String email;
    private String nickname;
//    private String profileImage;

    public void setTel(String tel) {
        this.tel = tel.replace(",", "-");
    }

    public void setEmail(String email) {
        this.email = email.replace(",", "@");
    }

}
