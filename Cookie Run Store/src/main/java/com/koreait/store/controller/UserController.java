package com.koreait.store.controller;

import com.koreait.store.dto.UserDTO;
import com.koreait.store.mapper.UserMapper;
import com.koreait.store.service.UserService;
import com.koreait.store.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    // validator > UserValidator
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new UserValidator());
    }
    
    @Autowired private UserService userService;

//    @Autowired private UserMapper userMapper;
//    컨트롤러와 매퍼사이에, 서비스를 둔다

// 컨트롤러는 연결해주는 역할을 해야지
//    여기서 디비를 다루는 건(, 를 -로 바꿔서 DB에 넣는다는등)
//    하는 건 알맞지 않기 때문 -> 서비스가 그 역할을 해줌

    @GetMapping("/login")
    public void get_login() {}
    /************************************************/
    // validation 추가 전
//    @GetMapping("/join")
//    public void get_join() {}

//    @PostMapping("/join")
//    public String post_join(UserDTO userDTO) {
////        System.out.println("post_join 실행됨!");
////        System.out.println("userDTO: " + userDTO);
//        userService.join_user(userDTO);
//        return "redirect:/user/login";
//    }

    // validation 추가 후
    @GetMapping("/join")
    public void get_join(@ModelAttribute UserDTO userDTO) {}

    @PostMapping("/join")
    public String post_join(
            @ModelAttribute @Validated UserDTO userDTO,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            return "user/join";
        }
        boolean joinResult = userService.join_user(userDTO);
        // 가입 성공이면 login 화면으로, 실패라면 회원가입 화면으로.
        return joinResult ? "redirect:/user/login" : "user/join";
    }
}
