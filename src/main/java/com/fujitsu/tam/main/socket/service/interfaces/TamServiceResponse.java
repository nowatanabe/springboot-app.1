package com.fujitsu.tam.main.socket.service.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface TamServiceResponse<O> {
    O getResponse();
    void setResponse(O response);
}
