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
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Harshul on 8/22/2015.
 */
public class clientservercon {
    public clientservercon()
    {
    }

    public void makehttprequest(String url)
    {

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet(url);

            httpClient.execute(httpGet);
            Log.d("QDROID1", url);
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
