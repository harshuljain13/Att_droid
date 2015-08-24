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
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class MainActivity extends Activity implements OnClickListener{

    Button ad;
    Button rm;
    EditText name_emp;
    EditText emp_id;
    clientservercon csobj;
    private GestureDetector gestureDetector;
    String url="http://hj1610.site40.net/feed_empl.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("x1","x1");
        setContentView(R.layout.activity_main);
        Log.d("x2","x2");

        gestureDetector = new GestureDetector(new SwipeGestureDetector());
        ad=(Button)findViewById(R.id.add1);
        rm=(Button)findViewById(R.id.rem);
        name_emp=(EditText)findViewById(R.id.emp_name);
        emp_id=(EditText)findViewById(R.id.emp_id);
        ad.setOnClickListener(this);
        rm.setOnClickListener(this);
        csobj=new clientservercon();
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
        Intent i=new Intent(this,Emp_status.class);
        startActivity(i);
        finish();
    }

    private void onRightSwipe() {
        // Do something
        Toast toast=Toast.makeText(getApplicationContext(),"swipe in left direction",Toast.LENGTH_SHORT);
        toast.show();

    }

    // Private class for gestures
    private class SwipeGestureDetector
            extends GestureDetector.SimpleOnGestureListener {
        // Swipe properties, you can change it to make the swipe
        // longer or shorter and speed
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_MAX_OFF_PATH = 200;
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
                    MainActivity.this.onLeftSwipe();

                    // Right swipe
                } else if (-diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    MainActivity.this.onRightSwipe();
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    String url1;
    String x,y;
    @Override
    public void onClick(View v)
    {
        x= name_emp.getText().toString();
        y=emp_id.getText().toString();
        x=x.replaceAll("\\s","_");
        x=x.toUpperCase();
        y=y.toUpperCase();
        if(x.equals("") || y.equals(""))
        {
            Toast toast=Toast.makeText(getApplicationContext(),"Complete the details",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if(x.length()>50 || y.length()>5 || y.length()<5 )
        {
            Toast toast=Toast.makeText(getApplicationContext(),"Employee id must be of 5 characters",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (y.charAt(0)!='E')
        {
            Toast toast=Toast.makeText(getApplicationContext(),"Employee id must start with 'E1001'",Toast.LENGTH_SHORT);
            toast.show();
            return;

        }
switch(v.getId())
{
    case R.id.add1 :

        url1="?name="+x+"&id="+y+"&store=1&remove=0";
        new AsyncTask<Void,Void,Boolean>()
        {
        ProgressDialog pDialog=new ProgressDialog(MainActivity.this);
        public void onPreExecute()
            {
                pDialog.setTitle("adding");
                pDialog.setMessage("executing");
                pDialog.setIndeterminate(true);
                pDialog.show();
            }
        public Boolean doInBackground(Void...x)
            {
            csobj.makehttprequest(url,url1);
            Log.d("url",url1);
                return true;
                }
        public void onPostExecute(Boolean b)
            {
pDialog.dismiss();
                }
        }.execute();
        break;
    case R.id.rem :
        //removing from database
        url1="?name="+x+"&id="+y+"&store=0&remove=1";
        new AsyncTask<Void,Void,Boolean>()
        {
            ProgressDialog pDialog=new ProgressDialog(MainActivity.this);
            public void onPreExecute()
            {
                pDialog.setTitle("removing");
                pDialog.setMessage("executing");
                pDialog.setIndeterminate(true);
                pDialog.show();
            }
            public Boolean doInBackground(Void... x)
            {
                csobj.makehttprequest(url,url1);
                Log.d("url",url1);
                return true;
            }
            public void onPostExecute(Boolean b)
            {
                pDialog.dismiss();
            }
        }.execute();

        break;
}
    }

}
