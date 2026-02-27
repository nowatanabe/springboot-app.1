package jp.go.jra.totalizator.common.online.socket;

import java.util.List;

import com.fujitsu.tam.main.socket.service.data.ProcHandlingInfo;
import com.fujitsu.tam.main.socket.service.data.TamSocketRequestDto;
import com.fujitsu.tam.main.socket.service.data.TamSocketResponseDto;
import com.fujitsu.tam.main.socket.service.interfaces.TamServiceResponse;
import com.fujitsu.tam.main.socket.service.interfaces.TamScoketBaseService;
import com.fujitsu.tam.main.socket.service.interfaces.TamServiceRequest;

import jp.go.jra.totalizator.common.core.message.CommonMessageInfo;
import jp.go.jra.totalizator.common.online.context.SocketOnlineContextData;
import jp.go.jra.totalizator.common.online.service.BaseOnlineServiceInputBizPart;
import jp.go.jra.totalizator.common.online.service.BaseOnlineServiceOutputBizPart;
import jp.go.jra.totalizator.common.online.service.OnlineService;
import jp.go.jra.totalizator.common.online.service.OnlineServiceInputDto;
import jp.go.jra.totalizator.common.online.service.OnlineServiceOutputDto;
import jp.go.jra.totalizator.common.online.socket.management.LogicalChannelDefinition;

public abstract class BaseSocketOnlineController<IM extends BaseSocketMessage, I extends BaseOnlineServiceInputBizPart, O extends BaseOnlineServiceOutputBizPart> implements TamScoketBaseService {
    private final OnlineService<I, O> service;
    private final String programId;
    private final LogicalChannelDefinition logcalChannleDef;
    private static final int ERROR_PROGRESS_INFO_TRACE_ID_INDEX = 0;
    private static final int ERROR_PROGRESS_INFO_SOCKET_REQUEST_MESSAGE_INDEX = 1;
    private static final int ERROR_PROGRESS_INFO_INPUTT_DTO_INDEX = 2;
    private static final int ERROR_PROGRESS_INFO_OUTPUT_DTO_INDEX = 3;
    private static final int ERROR_PROGRESS_INFO_LENGTH = 4;

       
    public BaseSocketOnlineController(OnlineService<I, O> service) {
        this.service = service;
        this.programId  = this.getProgramId();
        this.logcalChannleDef = null;
    }

    @Override
    public final TamServiceResponse<TamSocketResponseDto> executeBusinessLogic(TamServiceRequest<TamSocketRequestDto> request, ProcHandlingInfo procHandlingInfo) {
        CommonSocketRequest<IM> socketRequest = null;
        OnlineServiceInputDto<I> input = null;
        OnlineServiceOutputDto<O> output = null;
 
        SocketOnlineControllerPreProcessResult<IM, I, O> preProcessResult = preProcess(request.getRequest().getMessage(), procHandlingInfo);
        output = service.executeProcess(input);
        return postProcess(socketRequest, input, output);
    }

    @Override
    public TamServiceResponse<TamSocketResponseDto> executeErrorBusinessLogic(TamServiceRequest<TamSocketRequestDto> request, ProcHandlingInfo handlingInfo) {
            return null;
        }

    /**
     * 業務ソケット契機コントローラーの実行プログラムIDを取得する。
     * @return 実行プログラムID
     * 業務ソケット契機コントローラーの「オンラインアプリ（ソケット）ID」を返却する。
     */
    protected abstract String getProgramId();

    /**
     * 入力電文（バイナリデータ）をソケット要求メッセージに変換する。
     * @param request ソケットで受信したリクエスト情報。
     * 入力電文（バイナリデータ）が格納される。
     * @return 入力電文（バイナリデータ）から作成したソケット要求メッセージ
     * ・共通部
     *   共通部のうち以下の項目を設定する。
     *   ・実行者ID: 入力電文から加入者を特定できる場合は、加入者番号を設定する。
     * ・業務部
     *   入力電文（バイナリデータ）から作成した業務データを格納する。
     */
    protected abstract CommonSocketRequest<IM> convertRequestMessage(byte[] request);

    /**
     * 業務単項目チェックを実施する。
     * @param request 入力電文（バイナリデータ）から作成したソケット要求メッセージ。
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @return 単項目チェック結果。以下が格納された項目ごとのエラー情報を保持するリスト。
     * ・メッセージID: チェック結果を示すメッセージID
     * ・メッセージ対象識別子: メッセージの対象を識別する値（項目IDなど）
     * ・メッセージ: チェック結果
     * 入力チェックエラーなしの場合は要素0のリストを返却する。
     */
    protected abstract List<CommonMessageInfo> validateRequest(CommonSocketRequest<IM> request);

    /**
     * 業務項目間チェックを実施する。
     * @param request 入力電文（バイナリデータ）から作成したソケット要求メッセージ。
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @return 項目間チェック結果。以下が格納された項目ごとのエラー情報を保持するリスト。
     * ・メッセージID: チェック結果を示すメッセージID
     * ・メッセージ対象識別子: メッセージの対象を識別する値（項目IDなど）
     * ・メッセージ: チェック結果
     * 入力チェックエラーなしの場合は要素0のリストを返却する。
     */
    protected abstract List<CommonMessageInfo> validateRequsetCrosss(CommonSocketRequest<IM> request);

    /**
     * リクエストメッセージを受け取り、入力DTOを作成する。
     * @param request 入力電文（バイナリデータ）から作成したソケット要求メッセージ。
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @return ソケット要求メッセージから作成した入力DTO.
     * ・共通部
     *   初期化のみ行い、値は設定しない。
     * ・業務部
     *   業務ごとに異なる値を設定する。
     */
    protected abstract OnlineServiceInputDto<I> createServiceInputDto(CommonSocketRequest<IM> request);
 
    /**
     * 業務処理正常終了時の応答を作成する。
     * ソケット要求メッセージ／入力DTO／出力DTOを受け取り、出力電文（バイナリデータ）に変換する。
     * @param request 入力電文（バイナリデータ）から作成したソケット要求メッセージ。
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @param input 共通オンラインサービスにインプットする入力DTO.
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @param output 業務処理からアウトプットされた出力DTO。
     * ・共通部
     *   処理結果コード: 常に「0: 正常」が設定される。
     * ・業務部
     * 　業務処理によって設定されたデータ
     * @return ソケットレスポンスのバイナリデータ
     * 出力電文がない場合はnullを返却する。
     */
    protected abstract byte[] createResponse(CommonSocketRequest<IM> request, OnlineServiceInputDto<I> input, OnlineServiceOutputDto<O> output);

    /**
     * 業務エラー発生時の応答を作成する。
     * ソケット要求メッセージ／入力DTO／出力DTOを受け取り、出力電文（バイナリデータ）に変換する。
     * @param request 入力電文（バイナリデータ）から作成したソケット要求メッセージ。
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @param input 共通オンラインサービスにインプットする入力DTO.
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @param output 業務処理からアウトプットされた出力DTO。
     * ・共通部
     *   処理結果コード:
     *     ・正常終了した場合、「0: 正常」
     *     ・共通入力チェックエラーが発生した場合、「1: 共通入力エラー」
     *     ・業務単項目チェックエラーが発生した場合、「2: 業務単項目チェックエラー」
     *     ・業務項目間チェックエラーが発生した場合、「3: 業務項目間チェックエラー」
     *     ・業務エラーが発生した場合、「4～89: 業務エラー」
     * ・業務部
     * 　業務ごとに異なる値が設定される。
     *   エラー発生個所によってはnullが設定される可能性がある。
     * @return ソケットレスポンスのバイナリデータ
     * 出力電文がない場合はnullを返却する。
     */
    protected abstract byte[] createBusinessErrorResponse(CommonSocketRequest<IM> request, OnlineServiceInputDto<I> input, OnlineServiceOutputDto<O> output);

    /**
     * システムエラー発生時の応答を作成する。
     * ソケット要求メッセージ／入力DTO／出力DTOを受け取り、出力電文（バイナリデータ）に変換する。
     * @param request 入力電文（バイナリデータ）から作成したソケット要求メッセージ。
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @param input 共通オンラインサービスにインプットする入力DTO.
     * 共通部と業務部で構成される。業務部は業務ごとに異なる値が設定される。
     * @param output 業務処理からアウトプットされた出力DTO。
     * ・共通部
     *   処理結果コード:
     *     ・システムエラーが発生した場合、「90～98: システムエラー」
     *     ・業務以外のシステムエラーが発生した場合、「99: 業務以外のシステムエラー」
     * ・業務部
     * 　業務ごとに異なる値が設定される。
     *   エラー発生個所によってはnullが設定される可能性がある。
     * @return ソケットレスポンスのバイナリデータ
     * 出力電文がない場合はnullを返却する。
     */
    protected abstract byte[] createSystemErrorResponse(CommonSocketRequest<IM> request, OnlineServiceInputDto<I> input, OnlineServiceOutputDto<O> output);

    /**
     * 追加の前処理を実施する。
     * @param request
     * @param procHandlingInfo
     */
    protected abstract void additionalPreProcess(byte[] request, ProcHandlingInfo procHandlingInfo);

    /**
     * 追加のエラー前処理を実施する。
     * @param request
     * @param procHandlingInfo
     */
    protected abstract void additionalErrorProcess(byte[] request, ProcHandlingInfo procHandlingInfo);

    /**
     * 追加の後処理を実施する。
     * @param request
     * @param procHandlingInfo
     */
    protected abstract void additionalPostProcess(byte[] request, ProcHandlingInfo procHandlingInfo);

    /**
     * 追加のエラー後処理を実施する。
     * @param request
     * @param procHandlingInfo
     */
    protected abstract void additionalErrorPostProcess(byte[] request, ProcHandlingInfo procHandlingInfo);

    /**
     * ソケット契機オンラインコンテキストデータのインスタンスを取得する。
     * @return ソケット契機オンラインコンテキストデータ
     */
    protected final SocketOnlineContextData getContextData() {
        return null;
    }

    private SocketOnlineControllerPreProcessResult<IM, I, O> preProcess(byte[] request, ProcHandlingInfo procHandlingInfo) {
        return null;
    }

    private TamServiceResponse<TamSocketResponseDto> postProcess(CommonSocketRequest<IM> request, OnlineServiceInputDto<I> input, OnlineServiceOutputDto<O> output) {
        return null;
    }
}