package mywork.attendance_system;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Harshul on 8/22/2015.
 */
public class clientservercon {
    String urlstring=null;
    public clientservercon()
    {
    }

    public void makehttprequest(String url,String url1)
    {

        try {
            urlstring=url+url1;
            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet(urlstring);

            httpClient.execute(httpGet);
            Log.d("QDROID1", urlstring);

        }

        catch (ClientProtocolException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
