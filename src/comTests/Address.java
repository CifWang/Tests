package comTests;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * get hostname and ip with InetAdress.getHostName(),and getHostAddress()
 * @author cifengwang
 *
 */
public class Address {
	public static void main(String[] args) {
		InetAddress ip;
		try {
			ip=InetAddress.getLocalHost();
			String localname=ip.getHostName();
			String localip=ip.getHostAddress();
			System.out.println("本地主机名： "+localname);
			System.out.println("本机ip地址： "+localip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
