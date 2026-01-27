document.addEventListener("DOMContentLoaded", (event) => {
    console.log("DOMContentLoaded: " + event);
    
    document.addEventListener("focusout", (event) => {
        console.log("focusoutEventHandler");
        if (funcFocusoutEvent === undefined) {
        }
        else {
            funcFocusoutEvent(event);
        }
    });

    document.addEventListener("focusin", (event) => {
        console.log("focusinEventHandler");
        if (funcFocusinEvent === undefined) {
        }
        else {
            funcFocusinEvent(event);
        }
    });

    document.addEventListener("submit", (event) => {
        console.log("submitEventHandler");
        if (funcSubmitEvent === undefined) {
        }
        else {
            funcSubmitEvent(event);
        }
    });
});