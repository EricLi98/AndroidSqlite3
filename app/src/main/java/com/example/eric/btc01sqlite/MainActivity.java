package com.example.eric.btc01sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private StudDbHelpler dbHelpler;
    private SQLiteDatabase db;
    private EditText etName;
    private EditText etAge;
    private EditText etHeight;
    private EditText etId;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbHelpler!=null){
            dbHelpler.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud_layout);
        dbHelpler=new StudDbHelpler(this);
        db=dbHelpler.getWritableDatabase();

        etAge=(EditText)this.findViewById(R.id.stuage) ;
        etHeight= (EditText) findViewById(R.id.stuheight);
        etName=(EditText)findViewById(R.id.stuname);
        etId=(EditText)findViewById(R.id.editTextId);
        Button bt=(Button)this.findViewById(R.id.buttonAdd);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student();
                student.setAge(Integer.parseInt(etAge.getText().toString()));
                student.setHeight(Integer.parseInt(etHeight.getText().toString()));
                student.setName((etName.getText().toString()));
                StudDao.insert(student,db);
                Toast.makeText(MainActivity.this,"insert success",Toast.LENGTH_LONG).show();
            }
        });
        bt=(Button)this.findViewById(R.id.buttonDispall);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList al=StudDao.query(null,db);
                String rst="";
                for(int i=0;i<al.size();i++){
                    rst+=((Student)al.get(i)).toString();
                }
                Toast.makeText(MainActivity.this,rst,Toast.LENGTH_LONG).show();
            }
        });
        bt=(Button)this.findViewById(R.id.buttonDelall);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudDao.delete(null,db);
                Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_LONG).show();
            }
        });
        bt=(Button)this.findViewById(R.id.buttonIdDel);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudDao.delete(etId.getText().toString(),db);
                Toast.makeText(MainActivity.this,"deleted:"+etId.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
        bt=(Button)this.findViewById(R.id.buttonIdQuery);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList al=StudDao.query(etId.getText().toString(),db);
                if(al.size()>0)
                    Toast.makeText(MainActivity.this,((Student)al.get(0)).toString(),Toast.LENGTH_LONG).show();
            }
        });
        bt=(Button)this.findViewById(R.id.buttonIdUpdate);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student();
                student.setAge(Integer.parseInt(etAge.getText().toString()));
                student.setHeight(Integer.parseInt(etHeight.getText().toString()));
                student.setName((etName.getText().toString()));
                student.setId(Integer.parseInt(etId.getText().toString()));
                StudDao.update(student,db);
                Toast.makeText(MainActivity.this,"update success",Toast.LENGTH_LONG).show();
            }
        });

        }

}
