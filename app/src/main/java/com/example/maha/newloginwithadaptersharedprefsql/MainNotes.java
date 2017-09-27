package com.example.maha.newloginwithadaptersharedprefsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainNotes extends AppCompatActivity {
    EditText edNote;
    Button addNote;

    ListView listView;
///////////////////////////////////////////////////////////////////////////    (logout)
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logOut:
            Intent i = new Intent(MainNotes.this, MainActivity.class);
            startActivity(i);
            finish();
            onBackPressed();
        }
            return true;
        }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
////////////////////////////////////////////////////////////////////////////  (logout)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notes);

        //Button for action par
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /////////////////////////////////


      Intent s = getIntent();

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
