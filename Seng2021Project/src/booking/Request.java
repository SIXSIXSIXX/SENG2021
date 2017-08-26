package booking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



import api.DistanceAPI;

public class Request {
	private String name;
	private String phone;
	private String address;
	private String ID;
	private long createTime;
	private String bookTime;
	private double distance;
	private String ModelName;
	private int rejectTimes=0;
	private String type = "pending";
	private String userType = null;
	private String publicName = null;
	File f;
	File g;
	public Request(String ID,String type) throws IOException{
		String path = "";
		if(type.equals("Dealer")){
			path = "UserInfo/Dealer/request/"+ID;
		}
		else{
			path = "UserInfo/Public/request/"+ID;
		}
		LineNumberReader rdr = new LineNumberReader(new FileReader(path));
		String line = null;
		line = rdr.readLine();
		line = line.replace("Name:", "");
		this.setName(line);
		line =rdr.readLine().replace("Phone:", "");
		this.setPhone(line);
		line = rdr.readLine().replace("Address:", "");
		this.setAddress(line);
		line = rdr.readLine().replace("Model:", "");
		this.setModelName(line);
		line = rdr.readLine().replace("ID:", "");
		this.setID(line);
		line = rdr.readLine().replace("Time:", "");
		this.setBookTime(line);
		line = rdr.readLine().replace("Distance:", "");
		if(!line.equals("")){
			this.setDistance(Float.parseFloat(line));
		}
		line = rdr.readLine().replace("Type:", "");
		this.setType(line);
		rdr.close();
	}
	public Request(String RealName,String Nickname,String phone,String address,String ModelName,String ID,String bookTime,String createTime,String type,double distance) throws IOException{
		this.name = RealName;
		this.phone = phone;
		this.ID = ID;
		this.bookTime = bookTime;
		this.createTime = Long.parseLong(createTime);
		this.address = address;
		this.userType = type;
		this.distance = distance;
		this.ModelName = ModelName;
		this.createFile(Nickname);
	}
	public Request(String name,String phone,String address,String filename) throws IOException{
		this.name = name;
		this.phone = phone;
		this.address = address;
		File file = new File("userInfo/Dealer/request/"+filename);
		LineNumberReader rdr= new LineNumberReader(new FileReader(file));
		String line =rdr.readLine();
		 line =rdr.readLine();	
		 line =rdr.readLine().replace("Address:", "");
		 rdr.close();
		 this.publicName = findName(filename);
		 DistanceAPI d = new DistanceAPI(line,this.address);
		this.distance = Integer.parseInt(d.Distance());
		this.createTime = Long.parseLong(filename);
		//this.ModifyFile(filename);
	}
	
	
	public void createFile(String Nickname) throws IOException{
		if(this.userType.equals("Public")){
			f = new File("userInfo/Dealer/request/"+this.createTime);
			PrintWriter ff= new PrintWriter(f,"UTF-8");
			ff.println("Name:"+this.name);
			ff.println("Phone:"+this.phone);
			System.out.println(this.phone);
			ff.println("Address:"+this.address);
			System.out.println(this.address);
			ff.println("Model:"+this.ModelName);
			ff.println("ID:"+this.ID);
			ff.println("Time:"+this.bookTime);
			ff.println("Distance:");
			ff.println("Type:"+this.type);
			ff.close();
			File pending = new File("userInfo/Public/"+Nickname+"/PendingRequest.txt");
			FileWriter a = new FileWriter(pending,true);
			a.write(this.createTime+"\n");
			a.close();
			g = new File("userInfo/Public/request/"+this.createTime);
			PrintWriter aa= new PrintWriter(g,"UTF-8");
			aa.println("Name:");
			aa.println("Phone:");
			aa.println("Address:");
			aa.println("Model:"+this.ModelName);
			aa.println("ID:"+this.ID);
			aa.println("Time:"+this.bookTime);
			aa.println("Distance:");
			aa.println("Type:"+this.type);
			aa.close();

		}
	}
	public void Reject(String filename) throws IOException{
		File file= new File("userInfo/Dealer/"+this.name+"/PendingRequest.txt");
		LineNumberReader rdr  = null;
		String line = null;
		ArrayList<String> lines = new ArrayList<String>();
		lines.clear();
		rdr = new LineNumberReader(new FileReader(file));
		while((line=rdr.readLine())!=null){
			if(line.equals(filename)){
				continue;
			}
			lines.add(line);
		}
		rdr.close();
		FileWriter oo = null;
		oo = new FileWriter(file,false);
		for(String str:lines){
			oo.write(str+"\n");
		}
		oo.close();
		File i = new File("userInfo/Dealer/"+this.name+"/RejectRequest.txt");
		oo = new FileWriter(i,true);
		oo.write(filename+"\n");
		oo.close();
		i = new File("userInfo/Public/request/"+filename);
		rdr = new LineNumberReader(new FileReader(i));
		lines.clear();
		while((line=rdr.readLine())!=null){
			if(line.contains("RejectTimes:")){
				String t = line.replace("RejectTimes:", "");
				line = line.replace(t, String.valueOf(Integer.parseInt(t)-1));
				//lines.add(line);
			}
			lines.add(line);
		}
		rdr.close();
		oo = new FileWriter(i,false);
		for(String str:lines){
			oo.write(str+"\n");
		}
		oo.close();
		
	}
	public boolean ModifyFile(String filename) throws IOException{
		g = new File("userInfo/Public/request/"+filename);
		LineNumberReader rdr = new LineNumberReader(new FileReader(g));
		String line = null;
		ArrayList<String> lines = new ArrayList<String>();
		line = rdr.readLine().replace("Name:", "Name:"+this.name);
		lines.add(line);
		line = rdr.readLine().replace("Phone:", "Phone:"+this.phone);
		lines.add(line);
		line = rdr.readLine().replace("Address:", "Address:"+this.address);
		lines.add(line);
		line = rdr.readLine();
		lines.add(line);
		line = rdr.readLine();
		lines.add(line);
		line = rdr.readLine();
		lines.add(line);
		line = rdr.readLine().replace("Distance:", "Distance:"+this.distance);
		lines.add(line);
		line = rdr.readLine();
		if(line.equals("Accepted")){
			rdr.close();
			return false;
		}
		line =line.replace("Type:pending", "Type:Accepted");
		lines.add(line);
		rdr.close();
		FileWriter oo = new FileWriter(g, false); 
		for(String str:lines){
			oo.write(str+"\n");
		}
		oo.close();
		File l = new File("userInfo/Dealer/request/"+filename);
		rdr = new LineNumberReader(new FileReader(l));
		lines.clear();
		while((line = rdr.readLine())!=null){
			if(line.equals("Distance:")){
				line = line.replace("Distance:", "Distance:"+this.distance);
			}
			if(line.equals("Type:pending")){
				line = line.replace("Type:pending", "Type:Accepted");
			}
			lines.add(line);
		}
		rdr.close();
		oo = new FileWriter(l,false);
		for(String str:lines){
			oo.write(str+"\n");
		}
		List<Vector3f> a = new ArrayList<Vector3f>();
		oo.close();
		File k = new File("userInfo/Dealer/"+this.name+"/PendingRequest.txt");
		lines.clear();
		rdr = new LineNumberReader(new FileReader(k));
		while((line=rdr.readLine())!=null){
			if(line.equals(filename)){
				continue;
			}
			lines.add(line);
		}
		rdr.close();
		oo = new FileWriter(k,false);
		for(String str:lines){
			oo.write(str+"\n");
		}
		oo.close();
		File i = new File("userInfo/Dealer/"+this.name+"/AcceptedRequest.txt");
		oo = new FileWriter(i,true);
		oo.write(filename+"\n");
		oo.close();
		i = new File("userInfo/Public/"+this.publicName+"/PendingRequest.txt");
		rdr = new LineNumberReader(new FileReader(i));
		lines.clear();
		while((line=rdr.readLine())!=null){
			if(!line.equals(filename)){
				lines.add(line);
			}
		}
		rdr.close();
		oo = new FileWriter(i,false);
		for(String str:lines){
			oo.write(str+"\n");
		}
		oo.close();
		i = new File("userInfo/Public/"+this.publicName+"/AcceptedRequest.txt");
		oo = new FileWriter(i,true);
		oo.write(filename+"\n");
		oo.close();
		File[] allDealers = new File("userInfo/Dealer/").listFiles();
		for(File )
		return true;	
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getRejectTimes() {
		return rejectTimes;
	}
	public void setRejectTimes(int rejectTimes) {
		this.rejectTimes = rejectTimes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getModelName() {
		return ModelName;
	}
	public void setModelName(String modelName) {
		ModelName = modelName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String findName(String filename) throws IOException{
		String name = null;
		File[] directories = new File("userInfo/Public/").listFiles();
		for(File a:directories){
			if(!a.getName().equals("request")){
				File user = new File("userInfo/Public/"+a.getName()+"/PendingRequest.txt");
				LineNumberReader rdr = new LineNumberReader(new FileReader(user));
				String line =null;
				while((line=rdr.readLine())!=null){
					if(line.equals(filename)){
						name= a.getName();
						rdr.close();
						return name;
					}
				}
				rdr.close();
			}
			}
		
		return name;
	}
	
	public static List<String> openlist(String name,String type,String filename) throws IOException{		
		List<String> list= new ArrayList<String>();
		if(type.equals("Public")&&filename.equals("PendingRequest.txt")){
			movetoReject(name,type,filename);
		}
		File file = new File("userInfo/"+type+"/"+name+"/"+filename);
		LineNumberReader rdr = new LineNumberReader(new FileReader(file));
		String line = null;
		while((line=rdr.readLine())!=null){
			list.add(line);
		}
		rdr.close();
		return list;
}
	public static void movetoReject(String name,String type,String filename) throws IOException{
		File i = new File("userInfo/"+type+"/"+name+"/PendingRequest.txt");
		File j =null;
		LineNumberReader rdr = new LineNumberReader(new FileReader(i));
		LineNumberReader rdr2=null;
		ArrayList<String> IDs = new ArrayList<String>();
		ArrayList<String> rejectIDs = new ArrayList<String>();
		String line =null;
		String aline=null;
		while((line=rdr.readLine())!=null){
			 j = new File("userInfo/"+type+"/request/"+line);
			 rdr2 = new LineNumberReader(new FileReader(j));
				while((aline=rdr2.readLine())!=null){
					if(aline.contains("RejectTimes:")){
						String t = aline.replace("RejectTimes:", "");
						if(Integer.parseInt(t)==0){
							rejectIDs.add(line);
						}
						else{
							IDs.add(line);
							
						}
					}
					
				}
				rdr2.close();
		}
		rdr.close();
		FileWriter o = new FileWriter(i, false); 
		for(String str:IDs){
			o.write(str+"\n");
		}
		o.close();
		i = new File("userInfo/"+type+"/"+name+"/RejectRequest.txt");
		o = new FileWriter(i,true);
		for(String str:rejectIDs){
			o.write(str+"\n");
		}
		o.close();
	}
}
