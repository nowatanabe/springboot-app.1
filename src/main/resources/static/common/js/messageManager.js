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

function showOkCancelPopup(message, okFunc) {
    if (confirm(message)) {
        console.log("showOKCancelPopup: OK押下");
        okFunc();
    }
    else {
        console.log("showOKCancelPopup: CANCEL押下");
    }
}