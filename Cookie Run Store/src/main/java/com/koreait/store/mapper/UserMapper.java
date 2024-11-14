package com.koreait.store.mapper;

import com.koreait.store.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insertUser(UserDTO user);
}
