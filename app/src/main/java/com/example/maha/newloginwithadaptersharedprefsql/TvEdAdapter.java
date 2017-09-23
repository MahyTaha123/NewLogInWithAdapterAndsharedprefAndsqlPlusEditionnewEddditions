package com.example.maha.newloginwithadaptersharedprefsql;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Maha on 22/09/2017.
 */

public class TvEdAdapter extends ArrayAdapter<TvEdModel> {
    public TvEdAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<TvEdModel> objects) {
        super(context, 0, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_raw, parent, false);

        }
        TvEdModel model = getItem(position);

        TextView tvSNotes = (TextView) convertView.findViewById(R.id.tvSNotes);
        TextView tvLoading = (TextView) convertView.findViewById(R.id.tvLoading);
        tvSNotes.setText(model.getNote());
        tvLoading.setText(model.getState());


        return convertView;
    }
}
