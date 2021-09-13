package com.tcpUdp.test04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class TestReceive {
//接收方

	public static void main(String[] args) {
		System.out.println("老师上线了。。。。");
//		1、创建套接字
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9999);
			while(true) {
//				2、有一个空的数据包，打算接收对方传过来的数据包
				byte[] b = new byte[1024];
				DatagramPacket dp = new DatagramPacket(b,b.length);
//				3、接受对方的数据包，然后放入我们的dp数据包中填充
				ds.receive(dp);
//				接收完以后dp里面就填充好内容了

//				4、取出数据
				byte[] data = dp.getData();
				String s = new String(data,0,dp.getLength());
				System.out.println("学生对我说："+s);
				if(s.equals("byebye")) {
					System.out.println("学生已经下线了，老师也下线。。。。");
					break;
				}
//				老师进行回复
				Scanner sc = new Scanner(System.in);
				System.out.println("老师：");
				String str = sc.next();
				byte[] bytes = str.getBytes();
//			封装数据并且指定学生的ip和端口号
				DatagramPacket dp2 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"),8888);
//				发送：
					ds.send(dp2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

//		5、关闭资源
		ds.close();
	}
}
