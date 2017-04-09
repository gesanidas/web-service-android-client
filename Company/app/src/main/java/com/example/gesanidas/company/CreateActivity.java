package com.example.gesanidas.company;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.AsyncListUtil;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.gesanidas.company.utils.JsonUtils;
import com.example.gesanidas.company.utils.NetworkUtils;

import java.net.URL;

public class CreateActivity extends AppCompatActivity
{

    EditText editText,editText2,editText3,editText4,editText5;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);


    }


    public void create(View view)
    {

        Employee employee=new Employee(editText.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),Integer.parseInt(editText4.getText().toString()),editText5.getText().toString());
        new CreateEmployeeTask().execute(employee);
        startActivity(new Intent(CreateActivity.this,MainActivity.class));

    }


    public class CreateEmployeeTask extends AsyncTask<Employee, Void, Void>
    {
        @Override
        protected Void doInBackground(Employee... employees)
        {
            Employee emp=employees[0];
            try
            {
                NetworkUtils.createEmployee(CreateActivity.this,emp);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }




}
