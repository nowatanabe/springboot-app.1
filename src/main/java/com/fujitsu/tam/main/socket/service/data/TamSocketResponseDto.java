package com.fujitsu.tam.main.socket.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TamSocketResponseDto {
    List<SocketResponseInfo> responseInfoList;

    public TamSocketResponseDto(List<SocketResponseInfo> responseInfoList) {
        this.responseInfoList = responseInfoList;
    }

    public TamSocketResponseDto() {
    }

    public List<SocketResponseInfo> getResponseInfoList() {
        return responseInfoList;
    }

    public void setResponseInfoList(List<SocketResponseInfo> responseInfoList) {
        this.responseInfoList = responseInfoList;
    }
}