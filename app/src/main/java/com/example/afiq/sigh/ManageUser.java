package com.example.afiq.sigh;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManageUser extends AppCompatActivity {
    Button btnView,btnUpdate,btnDelete;
    EditText editName,editIc,editTel,editHall,editDate,editPurpose,editId;

    DatabaseHelper2 myDb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manageuser);

        myDb2 = new DatabaseHelper2(this);

        editId = (EditText)findViewById(R.id.editAdmin_id);
        editName = (EditText)findViewById(R.id.editAdmin_name);
        editIc = (EditText)findViewById(R.id.editAdmin_id);
        editTel = (EditText)findViewById(R.id.editAdmin_tel);
        editHall = (EditText)findViewById(R.id.editAdmin_hall);
        editDate = (EditText)findViewById(R.id.editAdmin_date);
        editPurpose = (EditText)findViewById(R.id.editAdmin_purpose);
        btnView = (Button)findViewById(R.id.button_View);
        btnUpdate = (Button)findViewById(R.id.button_Update);
        btnDelete = (Button)findViewById(R.id.button_Delete);

        viewAll();
        updateData();
        deleteData();
    }

    public void updateData(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = myDb2.updateData(editId.getText().toString(),editName.getText().toString()
                        ,editIc.getText().toString(),editTel.getText().toString(),editHall.getText().toString()
                                , editDate.getText().toString(),editPurpose.getText().toString());
                        if(isUpdate == true){
                            Toast.makeText(ManageUser.this,"Data is Updated",Toast.LENGTH_LONG).show();}
                            else
                            Toast.makeText(ManageUser.this,"Data is not Updated",Toast.LENGTH_LONG).show();
                        }
                }
        );
    }

    public void deleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deleteRows = myDb2.deleteData(editId.getText().toString());
                        if(deleteRows > 0)
                            Toast.makeText(ManageUser.this,"Data is Deleted",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(ManageUser.this,"Data is not deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

    public void viewAll(){
        btnView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb2.getAllData();
                        if(res.getCount() == 0){
                            //show message
                            showMessage("Error","Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id: " + res.getString(0)+"\n");
                            buffer.append("Name: " + res.getString(1)+"\n");
                            buffer.append("Ic: " + res.getString(2)+"\n");
                            buffer.append("Tel: " + res.getString(3)+"\n");
                            buffer.append("Hall: " + res.getString(4)+"\n");
                            buffer.append("Date: " + res.getString(5)+"\n");
                            buffer.append("Purpose: " + res.getString(6)+"\n\n");
                        }
                        //show message
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
