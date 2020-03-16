package com.example.afiq.sigh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdminActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuadmin);

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
        Intent nextPageNoti = new Intent(this, NotificationActivity.class);
        startActivity(nextPageNoti);
    }

    public void viewPage(View view) {
        Intent nextPageUserlist = new Intent(this, UsersListActivity.class);
        startActivity(nextPageUserlist);
    }

    public void managePage(View view) {
        Intent nextPageManage = new Intent(this, ManageUser.class);
        startActivity(nextPageManage);
    }

    public void notifyPage(View view) {
        Intent nextPageManage = new Intent(this, Notifyadmin.class);
        startActivity(nextPageManage);
    }
}
