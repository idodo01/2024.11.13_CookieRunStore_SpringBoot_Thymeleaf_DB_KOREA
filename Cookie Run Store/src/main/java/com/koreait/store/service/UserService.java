package com.koreait.store.service;

import com.koreait.store.dto.UserDTO;
import com.koreait.store.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void join_user(UserDTO userDTO) {
//        // 값이 여러개 들어오면 , 로 구분되는데
//        // 우린 각각 - 와 @로 바꾸어서 저장해줄 거임
//        userDTO.setTel(userDTO.getTel().replace(",", "-"));
//        userDTO.setEmail(userDTO.getEmail().replace(",", "@"));
        // UserDTO에서 처리해주는 걸로 바꿈


//        // 실제로 회원가입을 시킨다 (DB에 데이터를 저장한다)
        userMapper.insertUser(userDTO);
        System.out.println("유저가 등록되었다!");
    }
}
