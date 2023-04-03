package id.ac.uin.suska.mobilepw2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        TextView nameTXT = findViewById(R.id.nameView);

        String username = "Username Tidak Ada";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            username = extras.getString("username");
        }

        nameTXT.setText(username);
    }
}
