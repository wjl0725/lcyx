/**
 * Created by Administrator on 2016/9/14.
 */
var ws = new WebSocket("ws://localhost:8888");
ws.onopen = function() { // 当websocket创建成功，即会触发onopen事件
	var content = document.getElementById("content").value;
	if (content == null && content == "") {
		ws.send("sunnylinner"); // 用于将消息发送到服务端
		document.getElementById("span1").innerHTML = "1@@1";
	} else {
		ws.send(content);
		document.getElementById("span1").innerHTML = "2@@2";
	}
};
ws.onmessage = function(evt) {
	// 当客户端收到服务端发送来的消息时，会触发onmessage事件，参数evt.data中包含server传输过来的数据
	document.getElementById("span1").innerHTML = "3@@3";
	document.getElementById("span").innerHTML = "当前在线人数为：" + evt.data;
};
ws.onclose = function() {
	// 当客户端收到服务端发送的关闭连接的请求时，触发onclose事件
	alert("WebSocketClosed!");
};
ws.onerror = function() {
	// 如果出现连接，处理，接收，发送数据失败的时候就会触发onerror事件
	alert("WebSocketError!");
}
