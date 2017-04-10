package com.example.gesanidas.company.utils;

import android.content.Context;

import com.example.gesanidas.company.Employee;
import com.example.gesanidas.company.Skill;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils
{


    public static Employee[] parseJson(Context context, String inputJsonStr) throws JSONException
    {

        final  String  ID="id";
        final  String NAME="name";
        final String EMAIL="email";
        final String PASSWORD="password";
        final String TITLE="title";
        final String PHONE="phone";


        //JSONObject json = new JSONObject(inputJsonStr);
        JSONArray data=new JSONArray(inputJsonStr);
        Employee[] employees=new Employee[data.length()];

        for (int i=0;i<data.length();i++)
        {
            int id,phone;
            String name,email,password,title;
            JSONObject article = data.getJSONObject(i);
            id=article.getInt(ID);
            name=article.getString(NAME);
            email=article.getString(EMAIL);
            password=article.getString(PASSWORD);
            title=article.getString(TITLE);
            phone=article.getInt(PHONE);

            Employee employee=new Employee(id,name,email,password,phone,title);
            employees[i]=employee;

        }
        return employees;


    }

    public static Employee parseJsonEmpWithoutSkills(Context context, String inputJsonStr) throws JSONException
    {

        final  String  ID="id";
        final  String NAME="name";
        final String EMAIL="email";
        final String PASSWORD="password";
        final String TITLE="title";
        final String PHONE="phone";


        JSONObject json = new JSONObject(inputJsonStr);

        //JSONArray data=new JSONArray(inputJsonStr);
        //Employee employee=new Employee[data.length()];

        int id,phone;
        String name,email,password,title;
        id=json.getInt(ID);
        name=json.getString(NAME);
        email=json.getString(EMAIL);
        password=json.getString(PASSWORD);
        title=json.getString(TITLE);
        phone=json.getInt(PHONE);


        Employee employee=new Employee(id,name,email,password,phone,title);


        return employee;

    }

    public static Employee parseJsonEmpWithSkills(Context context, String inputJsonStr) throws JSONException
    {

        final  String  ID="id";
        final  String NAME="name";
        final String EMAIL="email";
        final String PASSWORD="password";
        final String TITLE="title";
        final String PHONE="phone";


        JSONArray data=new JSONArray(inputJsonStr);
        JSONObject json=data.getJSONObject(0);

        //JSONArray data=new JSONArray(inputJsonStr);
        //Employee employee=new Employee[data.length()];

            int id,phone;
            String name,email,password,title;
            id=json.getInt(ID);
            name=json.getString(NAME);
            email=json.getString(EMAIL);
            password=json.getString(PASSWORD);
            title=json.getString(TITLE);
            phone=json.getInt(PHONE);


            ArrayList<Skill> skills=new ArrayList<>();
            for (int i=0;i<data.length();i++)
            {
                JSONObject jsonSkill = data.getJSONObject(i);
                int skillID=jsonSkill.getInt("skillID");
                int employeeID=jsonSkill.getInt("employeeID");
                String description=jsonSkill.getString("description");
                skills.add(new Skill(skillID,employeeID,description));

            }


            Employee employee=new Employee(id,name,email,password,phone,title,skills);


        return employee;


    }

    public static JSONObject getJsonFromEmployeeforUpdate(Employee employee) throws JSONException
    {
        final  String  ID="id";
        final  String NAME="name";
        final String EMAIL="email";
        final String PASSWORD="password";
        final String TITLE="title";
        final String PHONE="phone";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(ID,employee.getId());
        jsonObject.put(NAME,employee.getName());
        jsonObject.put(EMAIL,employee.getEmail());
        jsonObject.put(PASSWORD,employee.getPassword());
        jsonObject.put(TITLE,employee.getTitle());
        jsonObject.put(PHONE,employee.getPhone());


        return jsonObject;
    }

    public static JSONObject getJsonFromEmployeeforCreate(Employee employee) throws JSONException
    {
        final  String NAME="name";
        final String EMAIL="email";
        final String PASSWORD="password";
        final String TITLE="title";
        final String PHONE="phone";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(NAME,employee.getName());
        jsonObject.put(EMAIL,employee.getEmail());
        jsonObject.put(PASSWORD,employee.getPassword());
        jsonObject.put(TITLE,employee.getTitle());
        jsonObject.put(PHONE,employee.getPhone());


        return jsonObject;
    }



    public static JSONObject getJsonFromSkillforUpdate(Skill skill) throws JSONException
    {
        final  String  SKILL_ID="skillID";
        final  String DESCRIPTION="description";
        final String EMPLOYEE_ID="employeeID";

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(SKILL_ID,skill.getSkillID());
        jsonObject.put(DESCRIPTION,skill.getDescription());
        jsonObject.put(EMPLOYEE_ID,skill.getEmployeeID());

        return jsonObject;
    }


    public static JSONObject getJsonFromSkillforCreate(Skill skill) throws JSONException
    {
        final  String DESCRIPTION="description";
        final String EMPLOYEE_ID="employeeID";

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(DESCRIPTION,skill.getDescription());
        jsonObject.put(EMPLOYEE_ID,skill.getEmployeeID());

        return jsonObject;
    }









}
