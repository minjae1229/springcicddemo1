package com.example.springcicddemo1.service;

import com.example.springcicddemo1.entity.Friend;
import com.example.springcicddemo1.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


// 통합 클래스 이름 Dao + Service
@Service
public class FriendDaoService {
    @Autowired
    FriendRepository repo;
    // 모든 유저 리스트 반환
    public List<Friend> friendList(){
        return repo.findAll();
    }
    @Transactional
    public boolean inputData() {
        try {
            Friend entity = new Friend();
            entity.setName("둘리");
            repo.save(entity);
            entity = new Friend();
            entity.setName("또치");
            repo.save(entity);
            entity = new Friend();
            entity.setName("도우너");
            repo.save(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}