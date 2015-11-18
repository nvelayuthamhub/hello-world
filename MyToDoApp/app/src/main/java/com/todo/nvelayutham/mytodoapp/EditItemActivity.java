package com.todo.nvelayutham.mytodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditItemActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 20;
    private final int RESULT_CODE = 21;

    EditText etUpdateValue;
    String position;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        etUpdateValue = (EditText)findViewById(R.id.etUpdateValue);

        setContentView(R.layout.activity_edit_item);
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

        position = getIntent().getStringExtra("position");
        value = getIntent().getStringExtra("value");
        //Toast.makeText(getApplicationContext(), "Edit Text :"+value, Toast.LENGTH_SHORT).show();
        ((EditText)findViewById(R.id.etUpdateValue)).setText(value);
    }

    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        Intent i = new Intent(EditItemActivity.this, ToDoActivity.class);
        i.putExtra("position", position);
        i.putExtra("value", ((EditText) findViewById(R.id.etUpdateValue)).getText().toString());
        setResult(RESULT_CODE, i);
        this.finish();
    }

    public void saveText(View view) {
        onSubmit(view);
    }
}
