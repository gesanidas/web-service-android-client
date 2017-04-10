package com.example.gesanidas.company;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.gesanidas.company.utils.NetworkUtils;

public class UpdateActivity extends AppCompatActivity
{

    EditText editText,editText2,editText3,editText4,editText5;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);

        employee=(Employee)getIntent().getSerializableExtra("employee");


        editText.setText(employee.getName());
        editText2.setText(employee.getEmail());
        editText3.setText(employee.getPassword());
        editText4.setText(String.valueOf(employee.getPhone()));
        editText5.setText(employee.getTitle());





    }

    public void update(View view)
    {
        Employee emp=new Employee(employee.getId(),editText.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),Integer.parseInt(editText4.getText().toString()),editText5.getText().toString());
        new UpdateEmployeeTask().execute(emp);
        startActivity(new Intent(UpdateActivity.this,MainActivity.class));

    }

    public class UpdateEmployeeTask extends AsyncTask<Employee, Void, Void>
    {
        @Override
        protected Void doInBackground(Employee... employees)
        {
            Employee emp=employees[0];
            try
            {
                NetworkUtils.updateEmployee(UpdateActivity.this,emp);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }
}
