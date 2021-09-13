package com.tcpUdp.test04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestSend {

	public static void main(String[] args) throws IOException {
		System.out.println("学生上线。。。。");
		DatagramSocket ds = null;
		try {
//			1、准备套接字
			ds = new DatagramSocket(8888);
			while(true) {
//				2、准备数据包
				Scanner sc = new Scanner(System.in);
				System.out.println("学生：");
				String str = sc.next();

				byte[] bytes = str.getBytes();
				/*
				 * 需要四个参数：
				 * 1、指的是传送数据转为字节数据
				 * 2、字节数组的长度
				 * 3、封装接收方的ip
				 * 4、指定接收方的端口号
				 */
				DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"),9999);
//			发送：
				ds.send(dp);
				if(str.equals("byebye")) {
					System.out.println("学生下线。。。");
					break;
				}
//				2、有一个空的数据包，打算接收对方传过来的数据包
				byte[] b = new byte[1024];
				DatagramPacket dp2 = new DatagramPacket(b,b.length);
				ds.receive(dp2);

//				4、取出数据
				byte[] data = dp2.getData();
				String s = new String(data,0,dp2.getLength());
				System.out.println("老师对我说："+s);
			}
		}catch(SocketException e) {
			e.printStackTrace();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			//		关闭资源
			if(ds != null) {
				ds.close();
			}
		}
	}
}
