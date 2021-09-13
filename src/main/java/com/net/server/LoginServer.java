package com.net.server;

import com.net.client.User;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(10000);
		while(true) {
			Socket server = serverSocket.accept();
//		获取输入流对象
			InputStream inputStream = server.getInputStream();
//		需要使用ObjectInputStrteam对象
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			User user = (User) objectInputStream.readObject();
			String str = "";
			if ("msb".equals(user.getUsername()) && "msb".equals(user.getPassword())) {
				System.out.println("欢迎你" + user.getUsername());
				str = "登录成功";
			} else {
				str = "登陆失败";
			}
//		截断输入流
			server.shutdownInput();
//		给客户端响应
			DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
			outputStream.writeUTF(str);
			server.shutdownOutput();
//		关闭流操作
			outputStream.close();
			inputStream.close();
			server.close();
		}
//		serverSocket.close();
	}


/*
* ServerSocket serverSocket = new ServerSocket(10000);
		while (true) {
			Socket server = serverSocket.accept();
//		获取输入流对象
			InputStream inputStream = server.getInputStream();
//		需要使用ObjectInputStrteam对象
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			User user = (User) objectInputStream.readObject();
			String str = "";
			if ("msb".equals(user.getUsername()) && "msb".equals(user.getPassword())) {
				str = "登录成功";
			} else {
				str = "登陆失败";
			}
//		截断输入流
			server.shutdownInput();
//		给客户端响应
			DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
			outputStream.writeUTF(str);
			server.shutdownOutput();
//		关闭流操作
			outputStream.close();
			inputStream.close();
			server.close();

		}

//		serverSocket.close();
*/
















}
