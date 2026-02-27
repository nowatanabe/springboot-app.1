package jp.go.jra.totalizator.common.online.socket;

import jp.go.jra.totalizator.common.online.service.BaseOnlineServiceInputBizPart;
import jp.go.jra.totalizator.common.online.service.BaseOnlineServiceOutputBizPart;
import jp.go.jra.totalizator.common.online.service.OnlineService;

public abstract class BaseNarSocketOnlineController<IM extends BaseSocketMessage, I extends BaseOnlineServiceInputBizPart, O extends BaseOnlineServiceOutputBizPart> extends BaseSocketOnlineController<IM, I, O> {

    public BaseNarSocketOnlineController(OnlineService<I, O> service) {
        super(service);
    }

    /**
     * テストコール電文を処理するクラスであるかどうかを返却する。
     * 本メソッドでは固定でfalseを返却するが、テストコール受信時の処理を実行する場合は、業務契機オンラインコントローラーで本メソッドをオーバーライドしtrueを返却するように実装する必要がある。
     * @return
     */
    protected boolean isTestCallMessage() {
        return false;
    }
}
