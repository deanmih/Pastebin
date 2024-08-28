package com.example.pastebin.SetButtonID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetButtonID {
    private static int ID;

    @PostMapping("/receiveBtnID")
    public void receiveBtnID(@RequestBody ButtonRequest request) {
        ID = request.getBtnID();
    }

    public static class ButtonRequest {
        private int btnID;

        public int getBtnID() {
            return btnID;
        }

        public void setBtnID(int btnID) {
            this.btnID = btnID;
        }
    }

    @GetMapping("/getID")
    public int getID() {
        return ID;
    }
}