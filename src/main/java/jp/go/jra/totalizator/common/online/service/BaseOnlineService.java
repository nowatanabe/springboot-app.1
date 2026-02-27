package jp.go.jra.totalizator.common.online.service;

public abstract class BaseOnlineService<I extends BaseOnlineServiceInputBizPart, O extends BaseOnlineServiceOutputBizPart>  implements OnlineService<I, O> {
    private Class<I> inputClass;
    private Class<O> outputClass;

    public BaseOnlineService(Class<I> inputClass, Class<O> outputClass) {
        this.inputClass = inputClass;
        this.outputClass = outputClass;
    }

    @Override
    public final OnlineServiceOutputDto<O> executeProcess(OnlineServiceInputDto<I> input) {
        preProcess();
        OnlineServiceOutputDto<O> output = mainProcess(input);
        postProcess();
        return output;
    }

    @Override
    public final void executeErrorProcess(OnlineServiceInputDto<I> input, OnlineServiceOutputDto<O> output) {
        executeBusinessErrorProcess(input, output);
    }

    /**
     * 業務主処理を行う。
     * @param input 入力DTO
     * @return 出力DTO
     * 以下を設定する。
     * ・処理結果コード：「0:正常」、「4～89:業務の利用領域（業務エラー）」
     * ・業務部：処理した結果のデータ（応答に使用するもの）
     */
    protected abstract OnlineServiceOutputDto<O> executeBusinessProcess(OnlineServiceInputDto<I> input);

    /**
     * 業務エラー処理を行う。
     * @param input 入力DTO（エラー事象によってはnullが設定される。）
     * @param output 出力DTO
     * 以下を設定する。
     * ・処理結果コード：「90～98:業務のシステムエラー」、「99:業務以外のシステムエラー」
     * ・業務部：処理した結果のデータ（エラー事象によってはnullが設定される。）
     */
    protected abstract void executeBusinessErrorProcess(OnlineServiceInputDto<I> input, OnlineServiceOutputDto<O> output);

    private void preProcess() {/* 処理なし。拡張用として本処理を定義する。 */}

    /**
     * 業務主処理を呼び出す。
     * @param input 入力DTO
     * @return 出力DTO
     */
    private OnlineServiceOutputDto<O> mainProcess(OnlineServiceInputDto<I> input) {
        return executeBusinessProcess(input);
    }

    private void postProcess() {/* 処理なし。拡張用として本処理を定義する。 */}
}
