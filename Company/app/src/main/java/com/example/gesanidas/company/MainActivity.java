package com.example.gesanidas.company;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.gesanidas.company.utils.JsonUtils;
import com.example.gesanidas.company.utils.NetworkUtils;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements EmpAdapter.ListItemClickListener
{

    RecyclerView  recyclerView;
    EmpAdapter employeeAdapter;
    LinearLayoutManager linearLayoutManager;
    private Employee[] employees;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        employeeAdapter=new EmpAdapter(employees,MainActivity.this);
        FetchEmployeesTask fetchEmployeesTask=new FetchEmployeesTask();
        fetchEmployeesTask.execute();
        recyclerView.setAdapter(employeeAdapter);


    }

    @Override
    public void onResume()
    {
        super.onResume();
        FetchEmployeesTask fetchEmployeeTask=new FetchEmployeesTask();
        fetchEmployeeTask.execute();
        recyclerView.setAdapter(employeeAdapter);

    }




    @Override
    public void onClick(Employee employee)
    {
        Bundle extras = new Bundle();
        extras.putSerializable("employee",employee);
        extras.putInt("id",employee.getId());
        Intent intent = new Intent(MainActivity.this,DetailActivity.class).putExtras(extras);
        startActivity(intent);

    }

    public void create(View view)
    {
        Intent intent = new Intent(MainActivity.this,CreateActivity.class);
        startActivity(intent);
    }




    public class FetchEmployeesTask extends AsyncTask<String, Void, Employee[]>
    {

        @Override
        protected Employee[] doInBackground(String... params)
        {
            URL url=NetworkUtils.getUrl(MainActivity.this);
            Employee[] employees=null;

            String response=null;
            try
            {
                response= NetworkUtils.getAllEmployees(url);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                employees= JsonUtils.parseJson(MainActivity.this,response);
                Log.i("dfd",employees[0].getName());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


            return employees;
        }


        @Override
        protected void onPostExecute(Employee[] employees)
        {
            super.onPostExecute(employees);
            employeeAdapter.setEmployee(employees);

        }


    }


}
