package mywork.attendance_system;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Harshul on 8/22/2015.
 */
public class clientservercon {
    String urlstring=null;
    static InputStream is =null;
    String jsonstr=null;
    public clientservercon()
    {
    }

    public String makehttprequest(String url,String method,String url1)
    {
        if(method.equals("POST"))
        {
            StringEntity se = null;
            try {
                se = new StringEntity(url1,"UTF-8");
                }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(se);
                httpPost.setHeader("Content-Type","application/json");
                httpPost.setHeader("Accept-Encoding","application/json");
                httpPost.setHeader("Accept-Language","en-US");
                HttpResponse hresponse = httpClient.execute(httpPost);
                HttpEntity hentity = hresponse.getEntity();
                is = hentity.getContent();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(method.equals("GET")) {
        try {
        urlstring = url + url1;
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(urlstring);

        HttpResponse hresponse = httpClient.execute(httpGet);

        HttpEntity hentity = hresponse.getEntity();
        is = hentity.getContent();
        Log.d("att_droid1", urlstring);
         } catch (ClientProtocolException e) {
        e.printStackTrace();
         } catch (IOException e) {
        e.printStackTrace();
        }
}
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            jsonstr=sb.toString();

        }
        catch(Exception e)
        {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }


        return jsonstr;
    }
}
