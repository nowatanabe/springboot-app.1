function getMessage(messageId, prams) {
    return "メッセージ";
}

function showMessage(messageId, message) {
    return;
}

function showOkPopup(popupTitle, messageList) {
    console.log("showOkPopup: ");
    alert("showOkPopup()");
}

function showOkCancelPopup(popupTitle, message, okFunc) {
    if (confirm(popupTitle + '\n' + message)) {
        okFunc();
    }
}