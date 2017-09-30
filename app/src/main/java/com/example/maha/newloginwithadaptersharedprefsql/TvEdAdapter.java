package com.example.maha.newloginwithadaptersharedprefsql;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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
        final TvEdModel model = getItem(position);

        Button overflow = (Button) convertView.findViewById(R.id.overFlow);

        final TextView tvSNotes = (TextView) convertView.findViewById(R.id.tvSNotes);
        TextView tvLoading = (TextView) convertView.findViewById(R.id.tvLoading);
        tvSNotes.setText(model.getNote());
        tvLoading.setText(model.getState());

        overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PopupMenu popupM = new PopupMenu(getContext(), view);
                // popupMenu.inflate(R.menu.poupup_menu);
                popupM.getMenuInflater()
                        .inflate(R.menu.poupup_menu, popupM.getMenu());
                popupM.show();
                popupM.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {


                        switch (menuItem.getItemId()) {
                            case R.id.remove:
                                remove(model);
                                notifyDataSetChanged();
                                break;
                            case R.id.toastMe:
                                Toast.makeText(getContext(), tvSNotes.getText().toString(), Toast.LENGTH_LONG).show();
                                break;

                        }


                        return true;
                    }
                });


            }
        });

        return convertView;
    }
}
