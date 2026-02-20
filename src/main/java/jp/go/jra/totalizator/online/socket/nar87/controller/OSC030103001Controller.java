package jp.go.jra.totalizator.online.socket.nar87.controller;

import java.util.List;

import jp.go.jra.totalizator.common.core.message.CommonMessageInfo;
import jp.go.jra.totalizator.common.online.service.OnlineServiceInputDto;
import jp.go.jra.totalizator.common.online.service.OnlineServiceOutputDto;
import jp.go.jra.totalizator.common.online.socket.BaseSocketOnlineController;
import jp.go.jra.totalizator.common.online.socket.CommonSocketRequest;

public class OSC030103001Controller extends BaseSocketOnlineController<Nar87Message, OSC030103001InputBizPart, OSC030103001OutputBizPart> {
    public OSC030103001Controller() {
        super(null);
    }

    //@Override
    public String getProgramId() {
        return "OSC030103001";
    }

    //@Override
    public CommonSocketRequest<Nar87Message> convertRequestMessage(byte[] requestData) {
        // TODO: Implement conversion logic
        return null;
    }

    //@Override
    public List<CommonMessageInfo> validateRequest(CommonSocketRequest<Nar87Message> request) {
        // TODO: Implement validation logic
        return null;
    }

    //@Override
    public List<CommonMessageInfo> validateRequestCross(CommonSocketRequest<Nar87Message> request) {
        // TODO: Implement cross-validation logic
        return null;
    }

    //@Override
    public OnlineServiceInputDto<OSC030103001InputBizPart> createServiceInputDto(CommonSocketRequest<Nar87Message> request) {
        // TODO: Implement input DTO creation logic
        return null;
    }

    //@Override
    public byte[] createResponse(CommonSocketRequest<Nar87Message> request, OnlineServiceInputDto<OSC030103001InputBizPart> input, OnlineServiceOutputDto<OSC030103001OutputBizPart> output) {
        // TODO: Implement response creation logic
        return null;
    }
}