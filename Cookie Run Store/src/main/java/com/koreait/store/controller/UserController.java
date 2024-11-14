package com.koreait.store.controller;

import com.koreait.store.dto.UserDTO;
import com.koreait.store.mapper.UserMapper;
import com.koreait.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
//    @Autowired private UserMapper userMapper; 
//    컨트롤러와 매퍼사이에, 서비스를 둔다
    
// 컨트롤러는 연결해주는 역할을 해야지
//    여기서 디비를 다루는 건(, 를 -로 바꿔서 DB에 넣는다는등)
//    하는 건 알맞지 않기 때문 -> 서비스가 그 역할을 해줌
    
    @Autowired private UserService userService;

    @GetMapping("/login")
    public void get_login() {}
    /************************************************/
    @GetMapping("/join")
    public void get_join() {}

    @PostMapping("/join")
    public String post_join(UserDTO userDTO) {
        System.out.println("post_join 실행됨!");
        System.out.println("userDTO: " + userDTO);
        userService.join_user(userDTO);
        return "redirect:/user/login";
    }
}
