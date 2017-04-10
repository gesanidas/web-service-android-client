package com.example.gesanidas.company;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.gesanidas.company.utils.NetworkUtils;

public class CreateSkillActivity extends AppCompatActivity
{

    EditText editText,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_skill);
        editText=(EditText)findViewById(R.id.editText8);
        editText2=(EditText)findViewById(R.id.editText9);
    }



    public void createSkill(View view)
    {

        Skill skill=new Skill(Integer.parseInt(editText.getText().toString()),editText2.getText().toString());
        new CreateSkillActivity.CreateSkillTask().execute(skill);
        startActivity(new Intent(CreateSkillActivity.this,MainActivity.class));

    }









    public class CreateSkillTask extends AsyncTask<Skill, Void, Void>
    {
        @Override
        protected Void doInBackground(Skill... skills)
        {
            Skill s=skills[0];
            try
            {
                NetworkUtils.createSkill(CreateSkillActivity.this,s);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }
}
