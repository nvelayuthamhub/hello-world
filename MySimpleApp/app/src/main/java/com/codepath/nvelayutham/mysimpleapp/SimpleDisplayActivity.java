package com.codepath.nvelayutham.mysimpleapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleDisplayActivity extends AppCompatActivity {

    // Edit test field
    private EditText etWords;
    private TextView tvLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etWords = (EditText)findViewById(R.id.etWords);
        tvLabel = (TextView) findViewById(R.id.tvLabel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_display, menu);
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

    // Fired when the button is clicked
    public void onSubmit(View view) {
        // Show a "Hellow World" message
        // a Toast = simple alert
        //Toast.makeText(this, "Hellow World", Toast.LENGTH_SHORT).show();

        // Get the value from the text field
        String fieldValue = etWords.getText().toString();
        // Set the value in the label
        tvLabel.setText(fieldValue);
        Toast.makeText(this, fieldValue, Toast.LENGTH_SHORT).show();

    }
}
