package com.example.afiq.sigh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RentActivity extends Activity {

    EditText editName, editIc,editTel,editHall,editDate,editPurpose;
    Button btnadd;

    DatabaseHelper2 myDb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        myDb2 = new DatabaseHelper2(this);

        editName = (EditText)findViewById(R.id.edit_Name);
        editIc = (EditText)findViewById(R.id.edit_Ic);
        editTel = (EditText)findViewById(R.id.edit_Tel);
        editHall = (EditText)findViewById(R.id.edit_Hall);
        editDate = (EditText)findViewById(R.id.edit_Date);
        editPurpose = (EditText)findViewById(R.id.edit_Purpose);
        btnadd = (Button)findViewById(R.id.buttonSubmitRent);

        AddData();



    }

    public void AddData(){
    btnadd.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = myDb2.insertData(editName.getText().toString(),editIc.getText().toString()
                    ,editTel.getText().toString(),editHall.getText().toString(),editDate.getText().toString()
                    ,editPurpose.getText().toString());
                    if(isInserted == true){
                        Toast.makeText(RentActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        Intent next = new Intent(RentActivity.this, NotificationActivity.class);
                        next.putExtra("Name", editName.getText().toString());
                        next.putExtra("Ic", editIc.getText().toString());
                        next.putExtra("Phone", editTel.getText().toString());
                        next.putExtra("Hall", editHall.getText().toString());
                        next.putExtra("Date", editDate.getText().toString());
                        next.putExtra("Purpose", editPurpose.getText().toString());

                        Intent next2 = new Intent(RentActivity.this, Notifyadmin.class);
                        next2.putExtra("Name", editName.getText().toString());
                        next2.putExtra("Ic", editIc.getText().toString());
                        next2.putExtra("Phone", editTel.getText().toString());
                        next2.putExtra("Hall", editHall.getText().toString());
                        next2.putExtra("Date", editDate.getText().toString());
                        next2.putExtra("Purpose", editPurpose.getText().toString());
                        startActivity(next);}

                    else
                        Toast.makeText(RentActivity.this,"Data is not Inserted",Toast.LENGTH_LONG).show();
                }
            }
    );
    }




//    public void onSignUpClick(View v) {
//        if (v.getId() == R.id.buttonSubmitRent) {
//            EditText name = (EditText) findViewById(R.id.edit_Name);
//            EditText ic = (EditText) findViewById(R.id.edit_Ic);
//            EditText tel = (EditText) findViewById(R.id.edit_Tel);
//            EditText date = (EditText) findViewById(R.id.edit_Date);
//            EditText purpose = (EditText) findViewById(R.id.edit_Purpose);
//
//            String namestr = name.getText().toString();
//            String icstr = ic.getText().toString();
//            String telstr = tel.getText().toString();
//            String datestr = date.getText().toString();
//            String purposestr = purpose.getText().toString();

//            if(!pass1str.equals(pass2str)){
//                Toast pass = Toast.makeText(RentActivity.this, "Password don't match" , Toast.LENGTH_LONG);
//                pass.show();
//            }
//
//            else{
//                book c = new book();
//                c.setName(namestr);
//                c.setIc(icstr);
//                c.setTel(telstr);
//                c.setDate(datestr);
//                c.setPurpose(purposestr);
//
//                myDb2.insertContact(c);
////            }


}
