package mywork.attendance_system;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harshul on 8/24/2015.
 */
public class custom_adapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;
   // private int[] colors;
    ArrayList<String> emp;
    ArrayList<Boolean> status;

    public custom_adapter(Activity activity , ArrayList<String> items,ArrayList<Boolean> status)
        {
            super(activity, R.layout.rowlayout, items);
            inflater = activity.getWindow().getLayoutInflater();
            emp=items;
            this.status=status;
            Log.d("1111",emp.get(1));
           // this.colors[0]=Color.parseColor("#FFFFF");
           // this.colors[1]=Color.parseColor("#D2E4FC");
        }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        convertView = inflater.inflate(R.layout.rowlayout, null);
        final TextView tview=(TextView)convertView.findViewById(R.id.t1);
        tview.setText(String.valueOf(emp.get(position)));

        if (position%2==1)
        {
            tview.setBackgroundColor(Color.parseColor("#F0F0F0"));
        }
        else
        {
            tview.setBackgroundColor(Color.parseColor("#D2E4FC"));
        }
       final Button b1=(Button)convertView.findViewById(R.id.A);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position1 = listView.getPositionForView(parentRow);
                if((b1.getText()).equals("A")) {
                    b1.setText("P");
                    status.set(position1,true);
                    Log.d("statussss",String.valueOf(status.get(position1)));
                }
                else {
                    b1.setText("A");
                    status.set(position1,false);
                    Log.d("statussss",String.valueOf(status.get(position1)));
                }
            }});
            return convertView;

        }

    }
