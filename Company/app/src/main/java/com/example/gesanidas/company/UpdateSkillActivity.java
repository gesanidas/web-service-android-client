package com.example.gesanidas.company;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.gesanidas.company.utils.NetworkUtils;

public class UpdateSkillActivity extends AppCompatActivity
{

    EditText editText,editText2;
    Skill skill;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_skill);
        editText=(EditText)findViewById(R.id.editText6);
        editText2=(EditText)findViewById(R.id.editText7);

        skill=(Skill)getIntent().getSerializableExtra("skill");

        editText.setText(String.valueOf(skill.getEmployeeID()));
        editText2.setText(skill.getDescription());

    }

    public void update(View view)
    {
        Skill s=new Skill(skill.getSkillID(),Integer.parseInt(editText.getText().toString()),editText2.getText().toString());
        new UpdateSkillActivity.UpdateSkillTask().execute(s);
        startActivity(new Intent(UpdateSkillActivity.this,MainActivity.class));

    }



    public class UpdateSkillTask extends AsyncTask<Skill, Void, Void>
    {
        @Override
        protected Void doInBackground(Skill... skills)
        {
            Skill s=skills[0];
            try
            {
                NetworkUtils.updateSkill(UpdateSkillActivity.this,s);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }
}
