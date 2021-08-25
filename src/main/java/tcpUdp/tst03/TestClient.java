package tcpUdp.tst03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {//客户端

//	这是一个main方法，是程序的入口：
	public static void main(String[] args) {
		//1、创建套接字：指定服务器的ip和端口号
		System.out.println("客户端启动了");
		Socket s = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		InputStream is = null;
		DataInputStream dis = null;
		try {
			s = new Socket("192.168.186.1",8888);
			//录入用户的账号和密码：
			Scanner sc = new Scanner(System.in);
			System.out.println("请录入您的账号：");
			String name = sc.next();
			System.out.println("请录入您的密码：");
			String pwd = sc.next();
			User user = new User(name, pwd);

			//		2、对于程序员来说，向外发送数据  感受-》》利用输出流
			 os = s.getOutputStream();
//			DataOutputStream dos = new DataOutputStream(os);
//			利用这个OutputStream就可以向外发送数据了，但是没有直接发送String的方法
//			所以我们又在OutputStream外面套了一个处理流：DataOutputStream
			 oos = new ObjectOutputStream(os);
			oos.writeObject(user);
			//接收服务器端的会话---》利用输入流：
			 is = s.getInputStream();
			 dis = new DataInputStream(is);
			boolean b = dis.readBoolean();
			if(b) {
				System.out.println("success");
			}else {
				System.out.println("对不起，登陆失败");
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3、关闭流 + 关闭网络资源
			try {
				if(dis != null) {
					dis.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(dis != null) {
					dis.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(os != null)
				{
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(s != null) {
					s.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
