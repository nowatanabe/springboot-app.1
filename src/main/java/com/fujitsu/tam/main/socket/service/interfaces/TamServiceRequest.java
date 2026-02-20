package com.fujitsu.tam.main.socket.service.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface TamServiceRequest<I> {
    I getRequest();
    void setRequest(I request);
}
