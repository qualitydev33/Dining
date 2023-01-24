package sellweb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("[websocket message]A new connection, amount:{}", webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("[websocket message]This link is disconnected, amount:{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("[websocket message]A new message from client side:{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocket webSocket: webSocketSet) {
            log.info("[websocket message]New message, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
