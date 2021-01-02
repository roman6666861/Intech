package com.mock.demo.data;



import com.mock.demo.entities.Message;

public interface MessageRepository {
    Message save(Message abstractEntity, String action);
}