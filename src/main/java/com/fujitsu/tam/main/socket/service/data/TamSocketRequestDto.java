package com.fujitsu.tam.main.socket.service.data;

import org.springframework.stereotype.Component;

@Component
public class TamSocketRequestDto {
    byte[] message;

    public TamSocketRequestDto(byte[] message) {
        this.message = message;
    }

    public TamSocketRequestDto() {
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }
}
