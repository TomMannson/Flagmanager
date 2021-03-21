package com.tommannson.flagmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TryController {

    @GetMapping("/info")
    public Data info(){
        return new Data("test22as2");
    }
}

class Data {

    String data;

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}