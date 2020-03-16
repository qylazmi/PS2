package com.example.afiq.sigh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Notifyadmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifyadmin);
        Bundle bundle = getIntent().getExtras();

        String nameB = bundle.getString("Name");
        String icB = bundle.getString("Ic");
        String telB = bundle.getString("Phone");
        String hallB = bundle.getString("Hall");
        String dateB = bundle.getString("Date");
        String purposeB = bundle.getString("Purpose");

        TextView nameView=(TextView)findViewById(R.id.nameBook);
        TextView icView=(TextView)findViewById(R.id.icBook);
        TextView phoneView=(TextView)findViewById(R.id.telBook);
        TextView hallView=(TextView)findViewById(R.id.hallBook);
        TextView dateView=(TextView)findViewById(R.id.dateBook);
        TextView purposeView=(TextView)findViewById(R.id.purposeBook);

        nameView.setText(nameB);
        icView.setText(icB);
        phoneView.setText(telB);
        hallView.setText(hallB);
        dateView.setText(dateB);
        purposeView.setText(purposeB);
    }
}
