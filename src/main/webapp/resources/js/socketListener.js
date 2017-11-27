function socketListener(message, channel, event) {
    console.log("try to update div")
    $('#divId').load("board.xhtml #divId");
    console.log("try to invoke updateScript()")
    updateScript();
    console.log("after updateScript()")
}