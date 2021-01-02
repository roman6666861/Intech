package com.mock.demo.data;

import com.mock.demo.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcMessageRepository implements MessageRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcMessageRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Message save(Message message, String string) {
        jdbc.update("insert into "+ string + " (msisdn, action, timestamp) values (?, ?, ?)",
                message.getMsisdn(),
                message.getAction().toString(),
                message.getTimestamp());
        return message;
    }
}
