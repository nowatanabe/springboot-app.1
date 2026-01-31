function funcSubmitEvent(event) {
    let doSubmit = false;
    showOkCancelPopup("xxx", "showOkCancelPopup", () => { doSubmit = true; })
    return doSubmit;
}
