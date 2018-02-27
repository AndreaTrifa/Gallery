package com.decode.gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PreviewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button backButton1;
    private Button backButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        backButton1 = (Button) findViewById(R.id.back_button1);
        backButton1.setOnClickListener(this);
        backButton2 = (Button) findViewById(R.id.back_button2);
        backButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.back_button1) {
           setResult(1);
        } else if (view.getId()==R.id.back_button2) {
            setResult(2);
        }
        finish();
    }
}
