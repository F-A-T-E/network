package com.tcpUdp;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Test02 {

	public static void main(String[] args) {
		InetSocketAddress isa = new InetSocketAddress("192.168.186.1", 8080);
		System.out.println(isa);
		System.out.println(isa.getHostName());
		System.out.println(isa.getPort());


	}

}
