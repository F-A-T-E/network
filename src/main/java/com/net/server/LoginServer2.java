package com.net.server;

import com.net.client.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(10000);
		while (true) {
			Socket socket = serverSocket.accept();
			LoginThread loginThread = new LoginThread(socket);
			new Thread(loginThread).start();
		}

//		serverSocket.close();
	}


}
