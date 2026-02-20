package com.fujitsu.tam.main.socket.service.interfaces;

import org.springframework.stereotype.Service;

import com.fujitsu.tam.main.socket.service.data.ProcHandlingInfo;
import com.fujitsu.tam.main.socket.service.data.TamSocketRequestDto;
import com.fujitsu.tam.main.socket.service.data.TamSocketResponseDto;

@Service
public interface TamScoketBaseService {
    TamServiceResponse<TamSocketResponseDto> executeBusinessLogic(TamServiceRequest<TamSocketRequestDto> request, ProcHandlingInfo handlingInfo);

    default TamServiceResponse<TamSocketResponseDto> executeErrorBusinessLogic(TamServiceRequest<TamSocketRequestDto> request, ProcHandlingInfo handlingInfo) {
        // エラー情報を設定するなどの処理を行う
        return null;
    }
}
