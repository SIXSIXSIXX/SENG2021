package users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Register {
	
	private static PrintWriter writer;
	public static boolean RegisterPublicInfo(String username, String password,String phonenumber,String address) throws IOException{
		File f =new File("userInfo/Public/"+username);
		if(f.exists()){
			System.out.println("有了");
			return false;
		}
		f.mkdir();
		File profile =new File("userInfo/Public/"+username+"/profile.txt");
		PrintWriter writer = new PrintWriter(profile, "UTF-8");
		writer.println("Password:"+password);
		writer.println("Phone:"+phonenumber);
		writer.println("Address:"+address);
		writer.close();
		File accept = new File("userInfo/Public/"+username+"/AcceptedRequest.txt");
		accept.createNewFile();
		File pending = new File("userInfo/Public/"+username+"/PendingRequest.txt");
		pending.createNewFile();
		File reject =new File("userInfo/Public/"+username+"/RejectRequest.txt");
		reject.createNewFile();
		return true;
	}
	public static boolean RegisterDealerInfo(String username, String password,String phonenumber,String address) throws IOException{
		File f =new File("userInfo/Dealer/"+username);
		if(f.exists()){
			System.out.println("有了");
			return false;
		}
		f.mkdir();
	
		File profile = new File("userInfo/Dealer/"+username+"/profile.txt");
		writer = new PrintWriter(profile, "UTF-8");
		writer.println("Password:"+password);
		writer.println("Phone:"+phonenumber);
		writer.println("Address:"+address);
		writer.close();
		File accept = new File("userInfo/Dealer/"+username+"/AcceptedRequest.txt");
		accept.createNewFile();
		File pending = new File("userInfo/Dealer/"+username+"/PendingRequest.txt");
		pending.createNewFile();
		File reject = new File("userInfo/Dealer/"+username+"/RejectRequest.txt");
		reject.createNewFile();
		File cars = new File("userInfo/Dealer/"+username+"/AvailableCars.txt");
		cars.createNewFile();
		return true;
	}
}
