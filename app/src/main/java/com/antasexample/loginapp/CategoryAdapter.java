package com.antasexample.loginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antas on 2016-12-15.
 */

public class CategoryAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public CategoryAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Categories object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
         CategoryHolder categoryHolder;
        if(row == null){
                LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            categoryHolder = new CategoryHolder();
            categoryHolder.tx_id = (TextView) row.findViewById(R.id.tx_id);
            categoryHolder.tx_name = (TextView) row.findViewById(R.id.tx_name);
            categoryHolder.tx_description = (TextView) row.findViewById(R.id.tx_description);
            row.setTag(categoryHolder);

        }

        else {
                categoryHolder = (CategoryHolder) row.getTag();
        }

        Categories categories = (Categories) this.getItem(position);
        categoryHolder.tx_id.setText(categories.getId());
        categoryHolder.tx_name.setText(categories.getName());
        categoryHolder.tx_description.setText(categories.getDescription());

        return row;
    }

    static class CategoryHolder{
        TextView tx_id, tx_name, tx_description;

    }
}
