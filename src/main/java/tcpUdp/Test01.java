package tcpUdp;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
//		封装ip
//		InetAddress ia = new InetAddress();不能直接创建对象，因为InetAddress()被default修饰了
		InetAddress ia = InetAddress.getByName("192.168.186.1");
		System.out.println(ia);
		InetAddress ia2 = InetAddress.getByName("localhost");
		System.out.println(ia2);

		InetAddress ia5 = InetAddress.getByName("www.mashibing.com");
		System.out.println(ia5);


		System.out.println(ia5.getHostName());		//获取域名
		System.out.println(ia5.getHostAddress());		//获取IP地址
	}

}
