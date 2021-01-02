package com.mock.demo.entities;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Message {
    private long msisdn;
    private Action action;
    private Timestamp timestamp;
}