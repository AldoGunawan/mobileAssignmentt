package id.ac.uin.suska.mobilepw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<activity2> userList;
    private RecyclerView recyclerView;
    private recylerAdapter.RecylerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList = new ArrayList<>();
        recyclerView = findViewById(R.id.mainRecyler);

        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnClickListener();
        recylerAdapter adapter = new recylerAdapter(userList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private void setOnClickListener() {
        listener = new recylerAdapter.RecylerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), activity3.class);
                intent.putExtra("username", userList.get(position).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {
        userList.add(new activity2("Aldo"));
        userList.add(new activity2("Kobo"));
        userList.add(new activity2("Alyss"));
        userList.add(new activity2("Bob"));
    }
}