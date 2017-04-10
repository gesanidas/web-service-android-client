package com.example.gesanidas.company;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gesanidas.company.utils.NetworkUtils;

public class SkillActivity extends AppCompatActivity
{

    TextView textView,textView1,textView2;
    Skill skill;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);
        textView=(TextView)findViewById(R.id.textView11);
        textView1=(TextView)findViewById(R.id.textView12);
        textView2=(TextView)findViewById(R.id.textView13);
        skill=(Skill) getIntent().getSerializableExtra("skill");

        textView.setText(String.valueOf(skill.getSkillID()));
        textView1.setText(String.valueOf(skill.getEmployeeID()));
        textView2.setText(skill.getDescription());

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
                        new DeleteSkillTask().execute(skill);
                        startActivity(new Intent(SkillActivity.this,MainActivity.class));
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        return;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(SkillActivity.this);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();

    }


    public void update(View view)
    {
        Intent intent = new Intent(SkillActivity.this,UpdateSkillActivity.class).putExtra("skill",skill);
        startActivity(intent);
    }










    public class DeleteSkillTask extends AsyncTask<Skill, Void, Void>
    {
        @Override
        protected Void doInBackground(Skill... skills)
        {
            Skill s=skills[0];
            try
            {
                NetworkUtils.deleteSkill(SkillActivity.this,s);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }




}
