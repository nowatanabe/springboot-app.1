document.addEventListener("DOMContentLoaded", (event) => {
    console.log("DOMContentLoaded: " + event);
    
    document.addEventListener("focusout", (event) => {
        if (funcFocusoutEvent !== undefined) {
            funcFocusoutEvent(event);
        }
    });

    document.addEventListener("focusin", (event) => {
        if (funcFocusinEvent !== undefined) {
            funcFocusinEvent(event);
        }
    });

    document.addEventListener("submit", (event) => {
        if (funcSubmitEvent !== undefined) {
            if (!funcSubmitEvent(event)) {
                event.preventDefault();
            }
        }
    });
});