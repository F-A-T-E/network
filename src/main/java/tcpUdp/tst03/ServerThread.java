package tcpUdp.tst03;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	// 线程：专门处理客户端请求
	InputStream is = null;
	ObjectInputStream ois = null;
	OutputStream os = null;
	DataOutputStream dos = null;
	Socket s = null;

	public ServerThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {

//			3、感受到的操作流：
			is = s.getInputStream();
			ois = new ObjectInputStream(is);

//			4、读取客户端发来的数据：
			User user = (User) (ois.readObject());
//			验证对象
			boolean flag = false;
			if (user.getName().equals("娜娜") && user.getPwd().equals("123123")) {
				flag = true;
			}

//			向客户端输出一句话   ----》 操作流  ----》输出流
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			dos.writeBoolean(flag);

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(os !=null ) {
						os.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(ois != null) {
						ois.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(is!=null) {
						is.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

