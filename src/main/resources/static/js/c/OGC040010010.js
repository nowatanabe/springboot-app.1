/**
 * 業務submitイベントハンドラ
 * 共通submitイベントハンドラが実行します。
 * @param {*} event 
 * @returns submitを実行する場合はtrueを返却します。submitをキャンセルする場合はfalseを返却します。
 */
function funcSubmitEvent(event) {
    // リクエストurlの変更、formのaction属性を各<input type="submit">に設定されてるdata-action属性とする。
    let form = event.target;
    let submitter = event.submitter;
    form.action = submitter.getAttribute("data-action");

    // submit可否の決定
    let doSubmit = false;
    switch (submitter.value) {
        case "初期表示要求":
            doSubmit = true;
            break;
        case "検索要求":
            doSubmit = true;
            break;
        case "実行要求（反映）":
            showOkCancelPopup("実行要求（反映）", "反映を実行しますか？", () => { doSubmit = true; });
            break;
        case "実行要求（予告）":
            showOkCancelPopup("実行要求（予告）", "予告を実行しますか？", () => { doSubmit = true; });
            break;
    }
    return doSubmit;
}
