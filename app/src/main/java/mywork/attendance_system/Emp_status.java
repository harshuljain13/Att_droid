package mywork.attendance_system;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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

    ArrayList<String> empname_id;
    ArrayList<String>status;
    ListView emview;
    Button sub;
    custom_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_status);
        gestureDetector = new GestureDetector(new SwipeGestureDetector());
        conobj=new clientservercon();
        empname_id=new ArrayList<String>();
        status=new ArrayList<String>();
        emview=(ListView)findViewById(R.id.listv);
        sub=(Button)findViewById(R.id.B);
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
            String jstring=conobj.makehttprequest(url,"GET",url1);
            Log.d("js",jstring);
               try
              {
                JSONArray jarray=new JSONArray(jstring);
                for(i=0;i<jarray.length();i++)
                  {
                      JSONObject jobj=jarray.getJSONObject(i);
                    empname_id.add(String.valueOf(jobj.getString("Name") +"-"+jobj.getString("Maker_id")) );
                    status.add("A");
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
                adapter = new custom_adapter(Emp_status.this, empname_id,status);
                Log.d("xy1111","high2");
                emview.setAdapter(adapter);

            }

        }.execute();

        sub.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick(View v) {

                final List<String> emp_name=new ArrayList<String>();
                final List<String> emp_id=new ArrayList<String>();
                final int arraysize=empname_id.size();
                for(String y : empname_id)
                {
                    String[] parts=y.split("-");
                    emp_name.add(parts[0]);
                    emp_id.add(parts[1]);
                }
                status=adapter.getstatus();

                new AsyncTask<Void,Void,Boolean>()
                {
                    ProgressDialog pDialog=new ProgressDialog(Emp_status.this);
                public void onPreExecute()
                {

                    pDialog.setTitle("Status");
                    pDialog.setMessage("sending status");
                    pDialog.setIndeterminate(true);
                    pDialog.show();

                }
                    public Boolean doInBackground(Void...x)
                    {
                        int i=0;
                        //making json
                        JSONObject employee=new JSONObject();
                        JSONArray jarray=new JSONArray();
                        for(i=0;i<arraysize;i++)
                        {
                            JSONObject jobj=new JSONObject();
                            try {
                                jobj.put("Name",emp_name.get(i));
                                jobj.put("Maker_id",emp_id.get(i));
                                jobj.put("status",status.get(i));
                                jarray.put(jobj);
                            }

                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            employee.put("employees",jarray);
                            url1=employee.toString();
                            Log.d("jsonstring1",url1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //making connection
                        conobj.makehttprequest(url,"POST",url1);

                        return true;
                    }
                    public void onPostExecute(Boolean b)
                    {
                        pDialog.setMessage("status sent");
                        pDialog.dismiss();
                    }
                }.execute();
                    }

        });
    }
/*

*/




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void onLeftSwipe() {
        // Do something
        Intent i=new Intent(this,employee_progress.class);
        startActivity(i);
        finish();
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
