package com.example.studentportal2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddWebsite extends AppCompatActivity {

    private EditText mPortalName, mPortalUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_website);



        mPortalName = findViewById(R.id.newPortalNameText);
        mPortalUrl = findViewById(R.id.newPortalUrlText);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textName = mPortalName.getText().toString();
                String textUrl = mPortalUrl.getText().toString();
                if(TextUtils.isEmpty(textName)) { //check if name is empty
                    Snackbar.make(view, getResources().getString(R.string.needName), Snackbar.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(textUrl)) { // check if url is empty
                    Snackbar.make(view, getResources().getString(R.string.needUrl), Snackbar.LENGTH_LONG).show();
                } else {
                    Intent intentResult = new Intent();
                    intentResult.putExtra(MainActivity.EXTRATEXT_NAME, textName);
                    intentResult.putExtra(MainActivity.EXTRATEXT_URL, textUrl);
                    setResult(Activity.RESULT_OK, intentResult);
                    finish();
                }
            }
        });
    }

}