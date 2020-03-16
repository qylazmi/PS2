package com.example.afiq.sigh;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.afiq.sigh.R;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView nameView = (TextView)findViewById(R.id.nameWelcome);
        nameView.setText(getIntent().getExtras().getString("EMAIL"));

    }

    public void eventPage(View view) {
        Intent nextPage = new Intent(this, EventActivity.class);
        startActivity(nextPage);
    }

    public void rentPage(View view) {
        Intent nextPageReg = new Intent(this, RentActivity.class);
        startActivity(nextPageReg);
    }

    public void notificationPage(View view) {
        Intent nextPageReg = new Intent(this, Notifyuser.class);
        startActivity(nextPageReg);
    }

    /*public void getData(){

        Cursor resData = myDb.getAllDAta();
        if(resData.getCount() == 0){
            //show message
            welcome.setText(" ");
            return;
        }
        else {
            while (resData.moveToNext()) {
                nama = (resData.getString(1));
                welcome.setText("Welcome, " + nama);
            }
        }
    }*/



}
