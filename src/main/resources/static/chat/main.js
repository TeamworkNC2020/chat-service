'use strict';

const userIdInputRef = $('#userIdInput');
const chatIdInputRef = $('#chatIdInput');
const messageInputRef = $('#messageInput');

let ws = new SockJS('http://localhost:8080/ws'); //FIXME
let stomp = Stomp.over(ws);

stomp.debug = () => {
    // console.log(message);
};
stomp.connect();

function onConnectButtonClick() {
    console.log("onConnectButtonClick")
    const topic = "/topic/chats/" + getChatId() + "/messages";
    console.log(topic);
    stomp.subscribe(topic, function (message) {
        onRetrieveMessage(JSON.parse(message.body));
    });
}


function onSendButtonClick() {
    console.log("onSendButtonClick")
    const topic = "/app/messages/send";
    const data = {
        chatId: getChatId(),
        userId: getUserId(),
        text: getMessage(),
    }
    stomp.send(topic, {}, JSON.stringify(data));
}


function onRetrieveMessage(message) {
    console.log("onRetrieveMessage");
    console.log(message);
}

function getUserId() {
    return userIdInputRef.val();
}

function getChatId() {
    return chatIdInputRef.val();
}

function getMessage() {
    return messageInputRef.val();
}