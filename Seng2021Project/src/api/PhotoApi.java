package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhotoApi {
	private static int count = 0;
	private static String key1 = "kfedvz6gx94beej72pek8hr7";
	private static String key2 = "8dnbr3cvhwpu7tv8tvzd7n6w";
	private static String key3 = "9pwp5u3fvdvprrpd2d5a6qw8";
	public static void getPhoto(String id) throws IOException{
		
		String link = "";
		int lengthCount = 0;
		URL url = null;
		if(count <= 3200){
			url = new URL("https://api.edmunds.com/v1/api/vehiclephoto/service/findphotosbystyleid?styleId="+id+"&fmt=json&api_key="+key1);
		}
		else if(count <= 8000){
			url = new URL("https://api.edmunds.com/v1/api/vehiclephoto/service/findphotosbystyleid?styleId="+id+"&fmt=json&api_key="+key2);
		}
		else{
			url = new URL("https://api.edmunds.com/v1/api/vehiclephoto/service/findphotosbystyleid?styleId="+id+"&fmt=json&api_key="+key3);
		}
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
		connection.setConnectTimeout(50000);
		connection.setRequestMethod("GET"); 
		connection.connect(); 
		BufferedReader json = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line=json.readLine();
		line = "{\n\"make\": "+line+"}";
		JSONObject obj = new JSONObject(line);
		JSONArray arr = obj.getJSONArray("make");
		
		for (int i = 0; i < arr.length(); i++){
			count++;
		    if(arr.getJSONObject(i).getString("shotTypeAbbreviation").equals("FQ") || lengthCount>=1){
		    	if(arr.getJSONObject(i).getJSONArray("photoSrcs").length()==0){
		    		continue;
		    	}

		    	for(int j=0; j<arr.getJSONObject(i).getJSONArray("photoSrcs").length() ;j++){
		    		String photoPath = arr.getJSONObject(i).getJSONArray("photoSrcs").get(j).toString();
		    		String[] e = photoPath.split("_");
		    		System.out.println(e[e.length-1]);
		    		String[] size = e[e.length-1].split("\\.");
		    		System.out.println(size[0]);
		    		if(Integer.parseInt(size[0]) < 600) continue;
		    		link +="http://media.ed.edmunds-media.com"+ arr.getJSONObject(i).getJSONArray("photoSrcs").get(j).toString()+"\n";
		    		lengthCount++;
		    		break;
		    	}
		    	

		    }
		    if(lengthCount == 5) break;
		  }
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter("/Users/corgiii/Documents/JS/Photo/"+id+".txt"));
		    writer.write(link);

		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
		
	}
	
	public static String getPhotoFromFile(String id) throws IOException{
		LineNumberReader rdr = new LineNumberReader(new FileReader("photo/"+id+".txt"));
		String link = rdr.readLine();
		if(link!=null&&!link.equals("")){
			rdr.close();
			return link;
		}
		rdr.close();
		return "";
	}
}
