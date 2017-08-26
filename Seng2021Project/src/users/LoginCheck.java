package users;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import Bean.UserBean;


public class LoginCheck{
	/**
	 * @throws IOException 
	 * 
	 */
	public static UserBean check(String username, String string) throws IOException{
		File user = new File("userInfo/Public/"+username+"/profile.txt");
		if(user.exists()){
			return checkPublicLoginInfo(username,string);
		}
		user = new File("userInfo/Dealer/"+username+"/profile.txt");
		if(user.exists()){
			return checkDealerLoginInfo(username,string);
		}
		return null;
	}
	
	
	public static UserBean checkPublicLoginInfo(String username, String string) throws IOException{
		LineNumberReader rdr = null;
		try {
			rdr = new LineNumberReader(new FileReader("userInfo/Public/"+username+"/profile.txt"));
		} catch (FileNotFoundException e) {
			return null;
		}
		
		String correctPassword = null;
		try {
			correctPassword = rdr.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		correctPassword = correctPassword.replaceFirst("Password:", "");
		System.out.println(correctPassword);
		System.out.println(string);
		
		if (correctPassword.equals(String.valueOf(string))){
			UserBean bean = new UserBean();
			bean.setType("Public");
			bean.setUserName(username);
			bean.setPassword(string);
			String phone =rdr.readLine().replace("Phone:", "");
			bean.setPhone(phone);
			String address = rdr.readLine().replace("Address:", "");
			bean.setAddress(address);
			rdr.close();
			rdr = new LineNumberReader(new FileReader("userInfo/Public/"+username+"/AcceptedRequest.txt"));
			String aRequest =null;
			while((aRequest = rdr.readLine())!=null){
				bean.setAcceptedRequest(aRequest);
			}
			rdr.close();
			rdr = new LineNumberReader(new FileReader("userInfo/Public/"+username+"/PendingRequest.txt"));
			String pRequest = null;
			while((pRequest = rdr.readLine())!=null){
				bean.setPendingRequest(pRequest);
			}
			rdr.close();
			String rRequest = null;
			rdr = new LineNumberReader(new FileReader("userInfo/Public/"+username+"/RejectRequest.txt"));
			while((rRequest = rdr.readLine())!=null){
				bean.setRejectedRequest(rRequest);
			}
			rdr.close();
			
			return bean;
		}
		rdr.close();
		return null;
	
	}
	public static UserBean checkDealerLoginInfo(String username, String string) throws IOException{
		LineNumberReader rdr = null;
			
	
			rdr = new LineNumberReader(new FileReader("userInfo/Dealer/"+username+"/profile.txt"));
				String correctPassword = rdr.readLine();
				
				correctPassword = correctPassword.replaceFirst("Password:", "");
				System.out.println(correctPassword);
				System.out.println(string);
				if (correctPassword.equals(String.valueOf(string))){
					UserBean bean = new UserBean();
					bean.setType("Dealer");
					bean.setUserName(username);
					bean.setPassword(string);
					String phone =rdr.readLine().replace("Phone:", "");
					bean.setPhone(phone);
					String address = rdr.readLine().replace("Address:", "");
					bean.setAddress(address);
					rdr.close();
					rdr = new LineNumberReader(new FileReader("userInfo/Dealer/"+username+"/AcceptedRequest.txt"));
					String aRequest =null;
					while((aRequest = rdr.readLine())!=null){
						bean.setAcceptedRequest(aRequest);
					}
					rdr.close();
					rdr = new LineNumberReader(new FileReader("userInfo/Dealer/"+username+"/PendingRequest.txt"));
					String pRequest = null;
					while((pRequest = rdr.readLine())!=null){
						bean.setPendingRequest(pRequest);
					}
					rdr.close();
					String rRequest = null;
					rdr = new LineNumberReader(new FileReader("userInfo/Dealer/"+username+"/RejectRequest.txt"));
					while((rRequest = rdr.readLine())!=null){
						bean.setRejectedRequest(rRequest);
					}
					rdr.close();
					String aCar = null;
					rdr = new LineNumberReader(new FileReader("userInfo/Dealer/"+username+"/AvailableCars.txt"));
					while((aCar = rdr.readLine())!=null){
						System.out.println(aCar);
						bean.setAvaiableCars(aCar);
					}
					rdr.close();
					return bean;
				}
				rdr.close();
				return null;
			
	
		

			
	}	
	
}