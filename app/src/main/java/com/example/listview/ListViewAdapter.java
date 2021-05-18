package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listview.models.Technology;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Technology> {
    private Activity activity;
    private List<Technology> mList;

    public ListViewAdapter(@NonNull Activity context, List<Technology>list) {
        super(context, R.layout.list_item_1, list);
        this.activity = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        View v = inflater.inflate(R.layout.list_item_1,parent,false);
        ImageView img = v.findViewById(R.id.img);
        TextView txt1 = v.findViewById(R.id.title);
        TextView txt2 = v.findViewById(R.id.sub);
        TextView txt3 = v.findViewById(R.id.content);

        Technology t = mList.get(position);

        img.setImageResource(t.getResouceImg());
        txt1.setText(t.getTitle());
        txt2.setText(t.getSub());
        txt3.setText(t.getContent());


        return v;
    }

    public Technology getItem(int position){
        return mList.get(position);
    }

}
