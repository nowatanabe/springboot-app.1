package jp.go.jra.totalizator.common.online.service;

public interface OnlineService<I extends BaseOnlineServiceInputBizPart, O extends BaseOnlineServiceOutputBizPart> {
    /**
     * 業務制御を行う。
     * @param input 入力DTO
     * @return 出力DTO
     */
    public OnlineServiceOutputDto<O> executeProcess(OnlineServiceInputDto<I> input);

    /**
     * エラー業務制御を行う。
     * @param input 入力DTO
     * @param output 出力DTO
     */
    public void executeErrorProcess(OnlineServiceInputDto<I> input, OnlineServiceOutputDto<O> output);

    /**
     * 入力DTOの業務部のクラスを取得する。
     * @return 入力DTOの業務部のクラス
     */
    public Class<I> getInputClass();

    /**
     * 出力DTOの業務部のクラスを取得する。
     * @return 出力DTOの業務部のクラス
     */
    public Class<I> getOuputClass();

}
