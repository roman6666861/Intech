package com.mock.demo.controllers;

import com.mock.demo.entities.Message;
import com.mock.demo.services.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@Controller
public class MainController {

    private MainService service;

    @Autowired
    public MainController(MainService service) {
        this.service = service;
    }

    @RequestMapping(value="/post", method = RequestMethod.POST,
            consumes = {"application/json"})
    public @ResponseBody Message postMessage(@RequestBody Message abstractEntity) {
        return service.save(abstractEntity);
    }
}
