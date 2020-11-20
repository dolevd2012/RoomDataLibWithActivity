package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dbroom.MainData;
import com.example.dbroom.RoomDB;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    MaterialButton addButton,resetButton;
    RecyclerView recyclerView;
    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.main_edit_text);
        addButton=findViewById(R.id.main_BTN_add);
        resetButton= findViewById(R.id.main_BTN_reset);
        recyclerView = findViewById(R.id.main_RECYCLER_view);


        database = RoomDB.getInstance(this);
        dataList = database.mainDao().getAll();


        linearLayoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MainAdapter(dataList,MainActivity.this);
        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString().trim();
                if(!text.equals("")) {
                    MainData data = new MainData();
                    data.setString(text);
                    database.mainDao().insert(data);
                    editText.setText("");
                    dataList.clear();
                    dataList.addAll( database.mainDao().getAll());
                    adapter.notifyDataSetChanged();
                }

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.mainDao().deleteAll(dataList);
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });




    }
}