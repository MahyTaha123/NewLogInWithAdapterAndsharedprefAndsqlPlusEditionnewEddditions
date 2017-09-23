package com.example.maha.newloginwithadaptersharedprefsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainNotes extends AppCompatActivity {
    EditText edNote;
    Button addNote;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notes);
        Intent i = getIntent();
//


        edNote = (EditText) findViewById(R.id.edNote);
        addNote = (Button) findViewById(R.id.addNote);

        listView = (ListView) findViewById(R.id.listView);




        final ArrayList<TvEdModel> items = new ArrayList<>();
        for (int i1 = 0; i1 < 6; i1++) {

            items.add(new TvEdModel("maha", "loading"));

        }


        final TvEdAdapter comAdapter = new TvEdAdapter(this,0,items);



        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = edNote.getText().toString();
                items.add(new TvEdModel(note, "Done"));
                edNote.setText(""); // to embty edit text

                listView.setAdapter(comAdapter);
                comAdapter.notifyDataSetChanged();


            }
        });

    }
}
