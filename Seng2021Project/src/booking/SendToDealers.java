package booking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import api.DistanceAPI;

public class SendToDealers {
	public static ArrayList<Dealer> findDealers(Request request) throws IOException{
		LineNumberReader rdr = null;
		LineNumberReader lol = null;
		String line = null;
		String hang = null;
		String name = null;
		String phone =null;
		String address = null;
		ArrayList<Dealer> dealers = new ArrayList<Dealer>();
		File[] directories = new File("userInfo/Dealer/").listFiles();
		for(File a:directories){
			if(!a.getName().equals("request")){
				File avCars = new File("userInfo/Dealer/"+a.getName()+"/AvailableCars.txt");
				rdr = new LineNumberReader(new FileReader(avCars));
				while((line = rdr.readLine())!=null){
					System.out.println(line);
					System.out.println(request.getID());
					if(line.equals(request.getID())){
						File profile = new File("userInfo/Dealer/"+a.getName()+"/profile.txt");
						lol = new LineNumberReader(new FileReader(profile));
						lol.readLine();
						hang = lol.readLine();
						phone = hang.replace("Phone:", "");
						hang = lol.readLine();
						address = hang.replace("Address:", "");
						Dealer dealer = new Dealer(a.getName(),address,phone);
						dealers.add(dealer);
						lol.close();
//						File pending = new File("userInfo/Dealer/"+a.getName()+"/PendingRequest.txt");
//						FileWriter fw = new FileWriter(pending,true);
//						fw.write(request.getCreateTime()+"\n");
//						fw.close();
						
					}
				}
				rdr.close();
			}
		}
		return dealers;
}
	public static void send(ArrayList<Dealer> dealers,Request request) throws IOException{
		if(dealers.size()<5){
			for(Dealer dealer:dealers){
				File pending = new File("userInfo/Dealer/"+dealer.getName()+"/PendingRequest.txt");
				FileWriter fw = new FileWriter(pending,true);
				fw.write(request.getCreateTime()+"\n");
				fw.close();
				
			}
			File pending = new File("userInfo/Public/request/"+request.getCreateTime());
			FileWriter fw = new FileWriter(pending, true);
			fw.write("RejectTimes:"+dealers.size()+"\n");
			fw.close();
		}
		else{
			for(Dealer dealer:dealers){
				DistanceAPI d = new DistanceAPI(request.getAddress(),dealer.getAddress());
				dealer.setDistance(Integer.parseInt(d.Distance()));
			}
			for(int i=0;i<dealers.size();i++){
				for(int j=1;j<dealers.size()-i;j++){
					if(dealers.get(j-1).getDistance()>dealers.get(j).getDistance()){
						Dealer temp = dealers.get(j-1);
						dealers.set(j-1, dealers.get(j));
						dealers.set(j, temp);
					}
				}
			}
			for(int k=0;k<5;k++){
				File pending = new File("userInfo/Dealer/"+dealers.get(k).getName()+"/PendingRequest.txt");
				FileWriter fw = new FileWriter(pending,true);
				fw.write(request.getCreateTime()+"\n");
				fw.close();
				pending = new File("userInfo/Public/request/"+request.getCreateTime());
				fw = new FileWriter(pending, true);
				fw.write("RejectTimes:5\n");
				fw.close();
			}
		}
	}
}