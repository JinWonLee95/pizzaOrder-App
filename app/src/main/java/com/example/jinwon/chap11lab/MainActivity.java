package com.example.jinwon.chap11lab;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text;
    RadioGroup rg;
    Button call;
    Button internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("MP01_06_201402406");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.pizzas);
        Button button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
        call = (Button)findViewById(R.id.call);
        internet = (Button)findViewById(R.id.internet);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Ordering.class);

                startActivityForResult(in,GET_STRING);
            }
        });


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                call.setEnabled(true);
                internet.setEnabled(true);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch(rg.getCheckedRadioButtonId()){
                    case R.id.dominos:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)15773082"));
                        break;
                    case R.id.mr:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)15770077"));
                        break;
                    case R.id.hut:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)15885588"));
                        break;
                }
                if(intent != null)
                    startActivity(intent);
            }
        });

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch(rg.getCheckedRadioButtonId()){
                    case R.id.dominos:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dominos.co.kr/"));
                        startActivity(intent);
                        break;
                    case R.id.mr:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mrpizza.co.kr"));
                        startActivity(intent);
                        break;
                    case R.id.hut:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pizzahut.co.kr"));
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == GET_STRING){
            if(resultCode == RESULT_OK){
                text.setText(data.getStringExtra("INPUT_TEXT"));
            }
        }
    }
}
