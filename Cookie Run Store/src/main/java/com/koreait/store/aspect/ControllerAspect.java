package com.koreait.store.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// pom.xml에 org.aspectj 디펜더시 추가
@Aspect
@Component
public class ControllerAspect {
    // 컨트롤러의 메서드가 실행될 때 실행되는 로그 출력해줌
    // 굳이 System.out.println(UserDTO); 하면서 확인할 필요없다
    @Before("execution(* com.koreait.store.controller.UserController.*(..))")
    public void method_start_log(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println(methodName + "이 실행됨");
        Object[] objects = joinPoint.getArgs();
        for(Object object : objects){
            System.out.println(object);
        }
    }

}
