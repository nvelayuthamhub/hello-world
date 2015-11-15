package com.todo.nvelayutham.mytodoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoActivity extends AppCompatActivity {

    ArrayList<String> toDoItems;
    ArrayAdapter<String> aToDoAdapter;
    ListView lvItems;
    EditText etEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        populateArrayItems();
        lvItems = (ListView) findViewById(R.id.lvItems);
        lvItems.setAdapter(aToDoAdapter);
        etEditText = (EditText) findViewById(R.id.etEditText);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                toDoItems.remove(position);
                aToDoAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void populateArrayItems() {
        toDoItems = new ArrayList<String>();
        toDoItems.add("Item 1");
        toDoItems.add("Item 2");
        toDoItems.add("Item 3");
        aToDoAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toDoItems);
    }

    public void onAddItem(View view) {
        aToDoAdapter.add(etEditText.getText().toString());
        etEditText.setText("");
    }
}
