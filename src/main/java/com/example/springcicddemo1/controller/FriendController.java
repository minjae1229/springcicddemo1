package com.example.springcicddemo1.controller;

import com.example.springcicddemo1.entity.Friend;
import com.example.springcicddemo1.service.FriendService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class FriendController {

  private final FriendService friendService;

  @GetMapping("/hello")
  public String helloGet() {
    return "환영합니다~~~ HomeController 의 처리 결과입니다.";
  }

  @GetMapping("/day")
  public String dayGet() {
    LocalDate ld = LocalDate.now();
    DayOfWeek dow = ld.getDayOfWeek();
    String korDay = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
    return korDay;
  }

  @GetMapping("/friends")
  public ResponseEntity<List<Friend>> friendsGet() {
    ResponseEntity<List<Friend>> entity = new ResponseEntity<>(friendService.friendList(), HttpStatus.OK);
    return entity;
  }

  @GetMapping("/inputFriends")
  public String inputFriendsGet() {
    if(friendService.inputData()) return "데이터 삽입에 성공했어요.";
    else return "데이터 삽입에 실패했어요.";
  }

  @GetMapping("/deleteFriends")
  public String deleteFriendsGet() {
    if(friendService.deleteData()) return "데이터 삭제에 성공했어요.";
    else return "데이터 삭제에 실패했어요.";
  }

  @GetMapping("/add")
  public int addGet(@RequestParam int num1, @RequestParam int num2 ) {
    return num1+num2;
  }

}
