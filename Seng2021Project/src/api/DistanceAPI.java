package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class DistanceAPI {
	private URL url = null;
	public DistanceAPI(String Paddress,String Daddress) throws IOException{
		Paddress = Paddress.replace(" ", "+");
		Daddress = Daddress.replace(" ", "+");
		this.url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+Paddress+"&destinations="+Daddress+"&key=AIzaSyC2WkEXl5VrJ6TR7wn1uYi8zjXWYWTdF2M");
		System.out.println(url);
	}
	public String Distance() throws IOException{
		HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
		
		connection.setConnectTimeout(50000);
		connection.setRequestMethod("GET"); 
		connection.connect(); 
		BufferedReader json = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		String lines = "";
		while((line = json.readLine())!=null){
			lines+=line;
		}
		JSONObject obj = new JSONObject(lines);
		JSONArray arr = obj.getJSONArray("rows");
		obj=arr.getJSONObject(0);
		arr = obj.getJSONArray("elements");
		obj = arr.getJSONObject(0);
		obj =obj.getJSONObject("distance");
		return obj.get("value").toString();
	}
}
