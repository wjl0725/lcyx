/**
 * Created by Administrator on 2016/9/14.
 */
var ws = new WebSocket("ws://localhost:8888");
ws.onopen = function() {
};
function mess() {
	ws.onmessage = function(evt) {
		// 当客户端收到服务端发送来的消息时，会触发onmessage事件，参数evt.data中包含server传输过来的数据
		document.getElementById("span").innerHTML += evt.data;
	};
}
ws.onclose = function() {
	// 当客户端收到服务端发送的关闭连接的请求时，触发onclose事件
	alert("WebSocketClosed!");
};
ws.onerror = function() {
	// 如果出现连接，处理，接收，发送数据失败的时候就会触发onerror事件
	alert("WebSocketError!");
};
