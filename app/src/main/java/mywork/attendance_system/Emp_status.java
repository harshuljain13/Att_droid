package mywork.attendance_system;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Emp_status extends Activity {

    private GestureDetector gestureDetector;

    clientservercon conobj;
    String url="http://hj1610.site40.net/get_update_empl.php";
    String url1;

    JSONObject jobj;
    JSONArray jarray;

    ArrayList<String> empname_id;
    ArrayList<Boolean> status;
    ListView emview;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_status);
        gestureDetector = new GestureDetector(new SwipeGestureDetector());
        conobj=new clientservercon();
        jobj=new JSONObject();
        empname_id=new ArrayList<String>();
        status=new ArrayList<Boolean>();
        emview=(ListView)findViewById(R.id.listv);

        new AsyncTask<Void,Void,Boolean>() {

            ProgressDialog pdialog=new ProgressDialog(Emp_status.this);

            public void onPreExecute()
            {
                pdialog.setTitle("employees");
                pdialog.setMessage("getting List");
                pdialog.setIndeterminate(true);
                pdialog.show();
            }

            public Boolean doInBackground(Void...x)
          {
            url1="";
            int i=0;
            String jstring=conobj.makehttprequest(url,url1);
            Log.d("js",jstring);
               try
              {
                jarray=new JSONArray(jstring);
                for(i=0;i<jarray.length();i++)
                  {
                    jobj=jarray.getJSONObject(i);
                    empname_id.add(String.valueOf(jobj.getString("Name") +"-"+jobj.getString("Maker_id")) );
                    status.add(false);
                         Log.d("empname", empname_id.get(i));
                  }
              }
                catch (JSONException e) {
                        e.printStackTrace();
                    }


            return true;
          }

        public void onPostExecute(Boolean b)
            {
                pdialog.dismiss();
                Log.d("xx1111","high1");
                custom_adapter adapter = new custom_adapter(Emp_status.this, empname_id,status);
                Log.d("xy1111","high2");
                emview.setAdapter(adapter);
            }

        }.execute();

    }





    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void onLeftSwipe() {
        // Do something
        Toast toast=Toast.makeText(getApplicationContext(),"swipe in right direction",Toast.LENGTH_SHORT);
        toast.show();
    }

    private void onRightSwipe() {
        // Do something
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();

    }

    // Private class for gestures
    private class SwipeGestureDetector
            extends GestureDetector.SimpleOnGestureListener {
        // Swipe properties, you can change it to make the swipe
        // longer or shorter and speed
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_MAX_OFF_PATH = 300;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               float velocityX, float velocityY) {
            try {
                float diffAbs = Math.abs(e1.getY() - e2.getY());
                float diff = e1.getX() - e2.getX();

                if (diffAbs > SWIPE_MAX_OFF_PATH)
                    return false;

                // Left swipe
                if (diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Emp_status.this.onLeftSwipe();

                    // Right swipe
                } else if (-diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Emp_status.this.onRightSwipe();
                }
            } catch (Exception e) {
                Log.e("YourActivity", "Error on gestures");
            }
            return false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_emp_status, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
