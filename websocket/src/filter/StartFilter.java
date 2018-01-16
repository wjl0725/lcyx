package filter;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.java_websocket.WebSocketImpl;

import socket.WebSocketUtil;
/**
 * Created by Administrator on 2016/9/13.
 */
public class StartFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        chain.doFilter(req, resp);
    }

    /**
     * 初始化
     * @param fc
     * @throws ServletException
     */
    public void init(FilterConfig fc) throws ServletException {
        this.starWebSocketOnline();
    }

    /**
     * 启动socket服务
     */
    public void starWebSocketOnline() {
        System.out.println("开始启动webSocket");
        WebSocketImpl.DEBUG = false;
        int port = 8888;
        WebSocketUtil s = null;
        try {
            s = new WebSocketUtil(port);
            s.start();
        } catch (UnknownHostException e) {
            System.out.println("启动webSocket失败！");
            e.printStackTrace();
        }
        System.out.println("启动webSocket成功！");
    }

}
