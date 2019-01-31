package kr.sys4u.chatting.server.command;

import java.net.Socket;
import kr.sys4u.chatting.server.Message;

public interface CommandProcessor {
	
	public void process(Socket socket, Message message);
	
}
