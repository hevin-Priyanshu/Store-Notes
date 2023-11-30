package com.demo.storenotesusingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    EditText textViewName;
    EditText textViewNotes;
    Button submitBtn;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.edit_text_name);
        textViewNotes = findViewById(R.id.edit_text_notes);
        submitBtn = findViewById(R.id.submit_btn);
        resetBtn = findViewById(R.id.reset_btn);
        recyclerView = findViewById(R.id.recycler_view);
        List<ModelClass> list = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MyAdapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        submitBtn.setOnClickListener(v -> {
            String editTextName = textViewName.getText().toString().trim();
            String editTextCompany = textViewNotes.getText().toString().trim();
            int itemPosition = list.size() - 1;

            if (!editTextName.isEmpty() && !editTextCompany.isEmpty()) {
                // Add text (item to ArrayList or MutableList)
                // Add Name as editTextName and Company name as editViewCompany
                Log.d("MyApp", "Position: " + itemPosition);
                list.add(0, new ModelClass(editTextName, editTextCompany));
                adapter.notifyItemInserted(0);
                Log.d("MyApp", "Adding item: " + editTextName + ", " + editTextCompany);
                int itemPosition2 = list.size() - 1;
                Log.d("MyApp", "Position: " + itemPosition2);

                // adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Text Set", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Please enter data, edit text cannot be blank", Toast.LENGTH_SHORT).show();
            }
        });

        resetBtn.setOnClickListener(v -> {
            String editTextName = textViewName.getText().toString();
            String editTextNotes = textViewNotes.getText().toString();

            if (!editTextName.isEmpty() && !editTextNotes.isEmpty()) {
                textViewName.getText().clear();
                textViewNotes.getText().clear();
                Toast.makeText(MainActivity.this, "Text Reset", Toast.LENGTH_SHORT).show();
            } else if (!editTextName.isEmpty() || !editTextNotes.isEmpty()) {
                textViewName.getText().clear();
                textViewNotes.getText().clear();
                Toast.makeText(MainActivity.this, "Text Reset", Toast.LENGTH_SHORT).show();
            }
        });


    }
}