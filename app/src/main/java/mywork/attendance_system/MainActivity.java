package mywork.attendance_system;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;


public class MainActivity extends Activity implements OnClickListener{

    Button ad;
    Button rm;
    EditText name_emp;
    EditText emp_id;
    clientservercon csobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("x1","x1");
        setContentView(R.layout.activity_main);
        Log.d("x2","x2");
        ad=(Button)findViewById(R.id.add1);
        rm=(Button)findViewById(R.id.rem);
        name_emp=(EditText)findViewById(R.id.emp_name);
        emp_id=(EditText)findViewById(R.id.emp_id);
        ad.setOnClickListener(this);
        rm.setOnClickListener(this);
        csobj=new clientservercon();
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
String url="http://hj1610.site40.net/feed_empl.php";
    String url1,url2;
    @Override
    public void onClick(View v)
    {
        String x= name_emp.getText().toString();
        String y=emp_id.getText().toString();
switch(v.getId())
{
    case R.id.add1 :
        url1=url+"?name="+x+"&id="+y+"&store=1&remove=0";
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
            csobj.makehttprequest(url1);
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
        url2= url+"?name="+x+"&id="+y+"&store=0&remove=1";
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
                csobj.makehttprequest(url2);
                Log.d("url",url2);
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
