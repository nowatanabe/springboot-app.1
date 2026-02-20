package jp.go.jra.totalizator.common.online.socket;

import com.fujitsu.tam.main.socket.service.data.ProcHandlingInfo;
import com.fujitsu.tam.main.socket.service.data.TamSocketRequestDto;
import com.fujitsu.tam.main.socket.service.data.TamSocketResponseDto;
import com.fujitsu.tam.main.socket.service.interfaces.TamServiceResponse;
import com.fujitsu.tam.main.socket.service.interfaces.TamScoketBaseService;
import com.fujitsu.tam.main.socket.service.interfaces.TamServiceRequest;

import jp.go.jra.totalizator.common.online.service.BaseOnlineServiceInputBizPart;
import jp.go.jra.totalizator.common.online.service.BaseOnlineServiceOutputBizPart;
import jp.go.jra.totalizator.common.online.service.OnlineService;
import jp.go.jra.totalizator.common.online.service.OnlineServiceInputDto;
import jp.go.jra.totalizator.common.online.service.OnlineServiceOutputDto;

public abstract class BaseSocketOnlineController<IM extends BaseSocketMessage, I extends BaseOnlineServiceInputBizPart, O extends BaseOnlineServiceOutputBizPart> implements TamScoketBaseService {
    private final OnlineService<I, O> service;

    public BaseSocketOnlineController(OnlineService<I, O> service) {
        this.service = service;
    }

    @Override
    public TamServiceResponse<TamSocketResponseDto> executeErrorBusinessLogic(TamServiceRequest<TamSocketRequestDto> request, ProcHandlingInfo handlingInfo) {
        return null;
    }

    protected abstract byte[] createResponse(CommonSocketRequest<IM> request, OnlineServiceInputDto<I> input, OnlineServiceOutputDto<O> output);
}