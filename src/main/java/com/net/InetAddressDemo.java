package com.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		 InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);
		 InetAddress inetAdd = InetAddress.getByName("www.baidu.com");
		System.out.println(inetAdd);
		System.out.println(inetAdd.getHostAddress());
		System.out.println(inetAdd.getHostName());
	}
}
