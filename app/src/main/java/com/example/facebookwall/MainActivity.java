package com.example.facebookwall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> modelArrayList = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Adapter(this,modelArrayList);
        recyclerView.setAdapter(adapter);
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        Model model = new Model(1,5,2,R.drawable.user_one,R.drawable.img_one,
                "David Williams","2 hrs","This is the status");
        modelArrayList.add(model);
        model = new Model(2,2,4,R.drawable.user_two,R.drawable.img_two,
                "Code Android","11 hrs","Let's Start Learning Android");
        modelArrayList.add(model);
        model = new Model(3,8,7,R.drawable.user_three,R.drawable.img_three,
                "Sanjay Singh","22 hrs","Prime Minister of India");
        modelArrayList.add(model);
        /*model = new Model(1,5,2,R.drawable.user_one,R.drawable.img_one,
                "David Williams","2 hrs","This is the status");
        modelArrayList.add(model);*/
        adapter.notifyDataSetChanged();
    }
}