package com.example.gesanidas.company;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Network;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gesanidas.company.utils.JsonUtils;
import com.example.gesanidas.company.utils.NetworkUtils;

import java.net.URL;

public class DetailActivity extends AppCompatActivity
{

    TextView textView,textView2,textView3,textView4,textView5;
    Employee employee;
    Button delete;
    int id;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        textView5=(TextView)findViewById(R.id.textView5);
        delete=(Button)findViewById(R.id.button);

        bundle=getIntent().getExtras();
        id=bundle.getInt("id");
        Log.i("id",String.valueOf(id));
        employee=(Employee) bundle.getSerializable("employee");
        //id=getIntent().getIntExtra("id",1);

        FetchEmployeeTask fetchEmployeeTask=new FetchEmployeeTask();
        fetchEmployeeTask.execute();

        //employee=(Employee)getIntent().getSerializableExtra("employee");

        /*
        textView.setText(employee.getName());
        textView2.setText(employee.getEmail());
        textView3.setText(employee.getPassword());
        textView4.setText(String.valueOf(employee.getPhone()));
        textView5.setText(employee.getTitle());

        */




    }

    public void delete(View view)
    {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        new DeleteEmployeeTask().execute(employee);
                        startActivity(new Intent(DetailActivity.this,MainActivity.class));
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        return;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
        //new DeleteEmployeeTask().execute(employee);
        //startActivity(new Intent(DetailActivity.this,MainActivity.class));
    }

    public void update(View view)
    {
        Intent intent = new Intent(DetailActivity.this,UpdateActivity.class).putExtra("employee",employee);
        startActivity(intent);
    }


    public class FetchEmployeeTask extends AsyncTask<String, Void, Employee>
    {

        @Override
        protected Employee doInBackground(String... params)
        {
            URL url=NetworkUtils.getUrl(DetailActivity.this);
            Employee employee=null;

            String response=null;
            try
            {
                response= NetworkUtils.getEmployee(url,id);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                employee= JsonUtils.parseJsonEmpWithoutSkills(DetailActivity.this,response);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


            return employee;
        }


        @Override
        protected void onPostExecute(Employee employee)
        {
            super.onPostExecute(employee);
            //employeeAdapter.setEmployee(employees);
            textView.setText(employee.getName());
            textView2.setText(employee.getEmail());
            textView3.setText(employee.getPassword());
            textView4.setText(String.valueOf(employee.getPhone()));
            textView5.setText(employee.getTitle());

        }


    }


    public class DeleteEmployeeTask extends AsyncTask<Employee, Void, Void>
    {
        @Override
        protected Void doInBackground(Employee... employees)
        {
            Employee emp=employees[0];
            try
            {
                NetworkUtils.deleteEmployee(DetailActivity.this,emp);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }
}
