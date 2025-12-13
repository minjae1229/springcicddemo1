package com.example.springcicddemo1.controller;

import com.example.springcicddemo1.entity.Friend;
import com.example.springcicddemo1.service.FriendDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@RestController
public class HomeController {
    @Autowired
    FriendDaoService service;
    @GetMapping("/hello")
    public String hello() {
        return "환영합니다~~~ HomeController 의 처리 결과입니다.";
    }  
    @GetMapping("/day")
    public String day() {
        LocalDate ld = LocalDate.now();
        DayOfWeek dow = ld.getDayOfWeek();
        String korDay = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
        return korDay;
    }
    @GetMapping("/friends")
    public ResponseEntity<List<Friend>> friends() {
        ResponseEntity<List<Friend>> entity = new ResponseEntity<>(service.friendList(), HttpStatus.OK);
        return entity;
    }
    @GetMapping("/inputfriends")
    public String input_friends() {
        if(service.inputData())
            return "데이터 삽입에 성공했어요.";
        else
            return "데이터 삽입에 실패했어요.";
    }
    @GetMapping("/add")
    public int addOfTwoNumber(@RequestParam int num1, @RequestParam int num2 ) {
        return num1+num2;
    }
}
