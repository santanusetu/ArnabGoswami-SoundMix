package com.chakroventures.arnabgoswamisoundmix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;


public class CustomGridViewAdapter extends ArrayAdapter {
    Context context;
    int layoutResourceId;
    ArrayList<String> data = new ArrayList<>();


    private static LayoutInflater inflater = null;

    public CustomGridViewAdapter(Context context, int layoutResourceId, ArrayList<String> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public class Holder {
        Button btn;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.row_grid, null);
        holder.btn = (Button) rowView.findViewById(R.id.btGridView);
        holder.btn.setText(data.get(position));
        holder.btn.setFocusable(false);
        holder.btn.setClickable(false);
        return rowView;

        /*View row = convertView;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            Button btn = (Button) row.findViewById(R.id.btGridView);
            btn.setText(data.get(position));
            btn.setFocusable(false);
            btn.setClickable(false);
            row.setTag(btn);
        } else {
            row.getTag();
        }
        return row;*/

    }

}
