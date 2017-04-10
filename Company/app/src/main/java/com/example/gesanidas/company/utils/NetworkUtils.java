package com.example.gesanidas.company.utils;



import android.content.Context;
import android.net.Uri;
import android.util.Log;


import com.example.gesanidas.company.Employee;
import com.example.gesanidas.company.Skill;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils
{
    private static final String BASE_URL="http://192.168.1.3:7777/api/employees/";
    private static final String SKILL_URL="http://192.168.1.3:7777/api/skills/";




    public static URL getUrl(Context context)
    {

        String url=BASE_URL;
        try
        {

            return new URL(url);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }





    public static String getAllEmployees(URL url) throws IOException
    {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String result=null;


        try
        {


            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null)
            {

                result = null;

            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line + "\n");
            }

            result = buffer.toString();
        }
        catch (IOException e)
        {
            Log.e("PlaceholderFragment", "Error ", e);
            result = null;
        }
        finally
        {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (final IOException e)
                {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }

        return result;

    }


    public static String getEmployee(URL url,int id) throws IOException
    {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String result=null;


        try
        {

            String u=url.toString()+String.valueOf(id);
            URL newUrl=new URL(u);
            urlConnection = (HttpURLConnection) newUrl.openConnection();
            Log.i("new url",newUrl.toString());
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null)
            {

                result = null;

            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line + "\n");
            }

            result = buffer.toString();
        }
        catch (IOException e)
        {
            Log.e("PlaceholderFragment", "Error ", e);
            result = null;
        }
        finally
        {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (final IOException e)
                {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }

        return result;

    }


    public static void deleteEmployee(Context context,Employee employee) throws IOException
    {
        HttpURLConnection httpURLConnection = null;
        String baseUrl=BASE_URL;
        URL url=new URL(baseUrl+String.valueOf(employee.getId()));
        Log.i("deleet url",url.toString());

        try
        {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.getInputStream();
            httpURLConnection.connect();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            if (httpURLConnection != null)
            {
                httpURLConnection.disconnect();
            }
        }
    }


    public static void createEmployee(Context context,Employee employee) throws IOException,JSONException
    {
        String baseUrl=BASE_URL;
        URL url=new URL(baseUrl);
        HttpURLConnection httpURLConnection = null;
        OutputStreamWriter dataOutputStream=null;
        try
        {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            dataOutputStream= new OutputStreamWriter(httpURLConnection.getOutputStream());
            dataOutputStream.write(JsonUtils.getJsonFromEmployeeforCreate(employee).toString());
            dataOutputStream.flush();
            dataOutputStream.close();
            httpURLConnection.getInputStream();
            httpURLConnection.connect();


        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

    }


    public static void updateEmployee(Context context,Employee employee) throws IOException,JSONException
    {
        String baseUrl=BASE_URL;
        URL url=new URL(baseUrl+String.valueOf(employee.getId()));

        HttpURLConnection httpURLConnection = null;
        OutputStreamWriter dataOutputStream=null;
        try
        {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            dataOutputStream= new OutputStreamWriter(httpURLConnection.getOutputStream());
            dataOutputStream.write(JsonUtils.getJsonFromEmployeeforUpdate(employee).toString());
            Log.i("json",JsonUtils.getJsonFromEmployeeforUpdate(employee).toString());
            dataOutputStream.flush();
            dataOutputStream.close();
            httpURLConnection.getInputStream();
            httpURLConnection.connect();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

    }



    public static void deleteSkill(Context context,Skill skill) throws IOException
    {
        HttpURLConnection httpURLConnection = null;
        String baseUrl=SKILL_URL;
        URL url=new URL(baseUrl+String.valueOf(skill.getSkillID()));
        Log.i("deleet url",url.toString());

        try
        {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.getInputStream();
            httpURLConnection.connect();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            if (httpURLConnection != null)
            {
                httpURLConnection.disconnect();
            }
        }
    }


    public static void updateSkill(Context context,Skill skill) throws IOException,JSONException
    {
        String b=SKILL_URL;
        URL url=new URL(b+String.valueOf(skill.getSkillID()));

        HttpURLConnection httpURLConnection = null;
        OutputStreamWriter dataOutputStream=null;
        try
        {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            dataOutputStream= new OutputStreamWriter(httpURLConnection.getOutputStream());
            dataOutputStream.write(JsonUtils.getJsonFromSkillforUpdate(skill).toString());
            Log.i("json",JsonUtils.getJsonFromSkillforUpdate(skill).toString());
            dataOutputStream.flush();
            dataOutputStream.close();
            httpURLConnection.getInputStream();
            httpURLConnection.connect();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

    }


    public static void createSkill(Context context,Skill skill) throws IOException,JSONException
    {
        String baseUrl=SKILL_URL;
        URL url=new URL(baseUrl);
        HttpURLConnection httpURLConnection = null;
        OutputStreamWriter dataOutputStream=null;
        try
        {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            dataOutputStream= new OutputStreamWriter(httpURLConnection.getOutputStream());
            dataOutputStream.write(JsonUtils.getJsonFromSkillforCreate(skill).toString());
            dataOutputStream.flush();
            dataOutputStream.close();
            httpURLConnection.getInputStream();
            httpURLConnection.connect();


        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

    }











}
