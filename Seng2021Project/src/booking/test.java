package booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class test {

	public static void main(String[] args) throws IOException {

		
	
		
		String id = "200477465";
		
		String link = "http://media.ed.edmunds-media.com";
		URL url = new URL("https://api.edmunds.com/v1/api/vehiclephoto/service/findphotosbystyleid?styleId="+id+"&fmt=json&api_key=9pwp5u3fvdvprrpd2d5a6qw8");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
		connection.setRequestMethod("GET"); 
		connection.connect(); 
		
		BufferedReader json = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line=json.readLine();
		line = "{\n\"make\": "+line+"}";
		JSONObject obj = new JSONObject(line);
		JSONArray arr = obj.getJSONArray("make");
		
		for (int i = 0; i < arr.length(); i++){
		    if(arr.getJSONObject(i).getString("shotTypeAbbreviation").equals("FQ")){
		    	link += arr.getJSONObject(i).getJSONArray("photoSrcs").get(0).toString();
		    	break;
		    }
		  }
	
	}
}
	

