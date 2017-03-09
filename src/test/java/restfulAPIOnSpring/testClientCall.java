package restfulAPIOnSpring;
//right:
//http://wenku.baidu.com/link?url=SDFTTyvHaX47dB7AvP2gPlsaCdSmKC8A-CT66IaexClPyHWAOI_IfhfcawMcbxSF_ezQXoMnwB19fagg64WsrVkB6-2bCCf3l59nHNquxva
//http://blog.csdn.net/javadwr/article/details/12616419?utm_source=tuicool&utm_medium=referral
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class testClientCall {
	private static String targetURL = "http://localhost:8081/restfulAPIOnSpring/v1/users/2";
public static void main(String[] args) throws IOException {
	try {

		URL restServiceURL = new URL(targetURL);

		HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();

		httpConnection.setRequestMethod("GET");

		httpConnection.setRequestProperty("Accept", "application/json");

		if (httpConnection.getResponseCode() != 200) {

		throw new RuntimeException("HTTP GET Request Failed with Error code : "

		+ httpConnection.getResponseCode());

		}

		BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(

		(httpConnection.getInputStream())));

		String output;

		System.out.println("Output from Server: \n");

		while ((output = responseBuffer.readLine()) != null) {

		System.out.println(output);

		}

		httpConnection.disconnect();

		} catch (MalformedURLException e) {

		e.printStackTrace();

		} catch (IOException e) {

		e.printStackTrace();

		} 
}
}
