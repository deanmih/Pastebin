package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class collectTextsController {
    private TreeMap<String, String> textMap = new TreeMap<>();
    private String key;
    
    @PostMapping("/txt")
    public void addTxt(@RequestBody txtCollector txtCollector) { 
        String key = txtCollector.getKey();
        String val = txtCollector.getVal();
        textMap.put(key, val);
    }

    @PostMapping("/sentKey")
    public void postMethodName(@RequestBody returnKey returnKey) {
        this.key = returnKey.getKey();
    }
    
    @GetMapping("/getValue")
    public String getTxt(@RequestParam String key) {
        String res = textMap.get(key);
        return res;
    }

    @GetMapping("/getKey")
    public String printVal() {
        return key;
    }  
}
