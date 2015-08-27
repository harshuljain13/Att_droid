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
import android.widget.LinearLayout;
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
    ArrayList<String> stats;

    public custom_adapter(Activity activity , ArrayList<String> items,ArrayList<String> statusc)
        {
            super(activity, R.layout.rowlayout, items);
            inflater = activity.getWindow().getLayoutInflater();
            emp=items;
            stats=statusc;

        }

    static class ViewHolder{
        public TextView tview;
        public Button b1;

    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){
       ViewHolder viewHolder = null;

        convertView = inflater.inflate(R.layout.rowlayout, null);
        viewHolder = new ViewHolder();
        viewHolder.tview=(TextView)convertView.findViewById(R.id.t1);
        viewHolder.b1=(Button)convertView.findViewById(R.id.A);
        viewHolder.b1.setText(stats.get(position));
        convertView.setTag(viewHolder);
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout parentRow = (LinearLayout) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position1 = listView.getPositionForView(parentRow);

                if((finalViewHolder.b1.getText()).equals("A")) {
                    finalViewHolder.b1.setText("P");
                    stats.set(position,"P");
                }
                else {
                    finalViewHolder.b1.setText("A");
                    stats.set(position,"A");
                }
            }});


        finalViewHolder.tview.setText(String.valueOf(emp.get(position)));

        if (position%2==1)
        {
            finalViewHolder.tview.setBackgroundColor(Color.parseColor("#F0F0F0"));
        }
        else
        {
            finalViewHolder.tview.setBackgroundColor(Color.parseColor("#D2E4FC"));
        }



            return convertView;

        }


    public ArrayList<String> getstatus()
    {
        return stats;
    }

    }
