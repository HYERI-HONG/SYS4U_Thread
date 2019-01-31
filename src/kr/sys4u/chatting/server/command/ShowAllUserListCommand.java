package kr.sys4u.chatting.server.command;

import java.net.Socket;
import java.util.List;
import kr.sys4u.chatting.client.Message;
import kr.sys4u.chatting.server.AccessedClientRunner;
import kr.sys4u.chatting.server.ServerSender;

public class ShowAllUserListCommand implements CommandProcessor {

	private final AccessedClientRunner runner;

	public ShowAllUserListCommand(AccessedClientRunner runner) {
		this.runner = runner;
	}

	@Override
	public void process(Socket socket, Message message) {

		List<String> roomUserList = runner.getRoomManager().findRoom(runner.getJoinRoomName()).getUserIdList();
		String userList = "<" + runner.getJoinRoomName() + "의 대화상대 목록>\n";
		int count = 1;
		for (String user : roomUserList) {
			userList += count + "." + user + "\n";
			count++;
		}
		new ServerSender(runner).send(socket, userList);
	}

}
