package booking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class AddCars {
	public static void addCars(String name,String[] carList) throws IOException{
		///Users/corgiii/Documents/JS/Seng2021Project/
		File dealer = new File("userInfo/Dealer/"+name+"/AvailableCars.txt");
		FileWriter fw = new FileWriter(dealer,true);
		for(String str:carList){
			fw.write(str+"\n");
		}
		fw.close();
		}
	public static void deleteCars(String name,String[] car) throws IOException{

		File dealer = new File("userInfo/Dealer/"+name+"/AvailableCars.txt");
		LineNumberReader rdr = new LineNumberReader(new FileReader(dealer));
		String line = null;
		ArrayList<String> cars = new ArrayList<String>();
		while((line=rdr.readLine())!=null){
			if(
				!line.equals(car[0])){
				cars.add(line);
			}
		}
		rdr.close();
		FileWriter fw = new FileWriter(dealer,false);
		for(String str:cars){
			fw.write(str+"\n");
		}
		fw.close();
	}
}
