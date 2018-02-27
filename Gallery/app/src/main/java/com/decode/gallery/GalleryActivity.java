package com.decode.gallery;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PREVIEW_REQUEST_TYPE=1;

    private Button mPreviewButton;
    private TextView resultText;
    private int resultValue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mPreviewButton = (Button) findViewById(R.id.button_preview);
        mPreviewButton.setOnClickListener(this);
        resultText = (TextView) findViewById(R.id.text_result);

        if (savedInstanceState!=null) {
            resultValue=savedInstanceState.getInt("result", 0);
            resultText.setText("Result" + resultValue);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button_preview) {
            Intent intent = new Intent(this, PreviewActivity.class);
            startActivityForResult(intent,PREVIEW_REQUEST_TYPE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PREVIEW_REQUEST_TYPE) {
            resultText.setText("Result" + resultCode);
            resultValue=resultCode;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("result", resultValue);
    }
}
