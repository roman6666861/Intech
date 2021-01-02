package com.mock.demo.services;

import com.mock.demo.data.MessageRepository;
import com.mock.demo.entities.Action;
import com.mock.demo.entities.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceImpl implements MainService{

    private final MessageRepository messageRepository;

    @Autowired
    public ServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message save(Message entity) {
        if (entity.getAction().equals(Action.PURCHASE)) {
            Message save = messageRepository.save(entity, Action.PURCHASE.toString());
            log.info("entity submitted: " + entity);
            return save;
        }
        else if (entity.getAction().equals(Action.SUBSCRIPTION)) {
            Message save = messageRepository.save(entity, Action.SUBSCRIPTION.toString());
            log.info("entity submitted: " + entity);
            return save;
        }
        return null;
    }
}
