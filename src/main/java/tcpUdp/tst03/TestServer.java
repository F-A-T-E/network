package tcpUdp.tst03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
//服务器
//这是一个main方法，是程序的入口
	public static void main(String[] args) {
		System.out.println("服务器启动了");
//1、创建套接字：指定服务器的端口号
		ServerSocket ss = null;
		Socket s = null;
		int count = 0;
//		定义一个计数器  用来计算客户端的请求
		try {
			ss = new ServerSocket(8888);
			// 2、等着客户端发来的信息：
			while (true) { // 加入死循环服务器一直监听客户端是否发送数据
				s = ss.accept();
//				阻塞方法：等待接收客户端的数据，什么时候接收到数据，什么时候程序继续向下执行。
//				accept()返回值为一个Socket，这个Socket其实就是客户端的Socket
//				接到这个Socket以后，客户端和服务器才真正产生了连接，才真正可以通信了

//				阻塞方法：等待接收客户端的数据，什么时候接收到数据，什么时候程序继续向下执行。
				// 每次过来的客户端的请求 靠线程处理
				new ServerThread(s).start();
				count ++;
//				输出请求的客户端的信息：
				System.out.println("当前是第"+count+"个用户访问我们的服务器,对应的用户是："+s.getInetAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
