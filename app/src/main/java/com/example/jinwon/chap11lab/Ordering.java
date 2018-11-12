package com.example.jinwon.chap11lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class Ordering extends AppCompatActivity {
    int pizzaCount=0;
    int spaCount=0;
    Button orderBtn;
    Button pizzaUp;
    Button pizzaDown;
    Button spaUp;
    Button spaDown;
    TextView pizzaView;
    TextView spaView;
    CheckBox pizzaCheck, spaCheck;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordering);

        orderBtn = (Button) findViewById(R.id.orderBtn);
        pizzaUp = (Button) findViewById(R.id.pizzaUp);
        pizzaDown = (Button) findViewById(R.id.pizzaDown);
        spaUp = (Button) findViewById(R.id.spaUp);
        spaDown = (Button) findViewById(R.id.spaDown);
        pizzaView = (TextView) findViewById(R.id.pizzaCount);
        spaView = (TextView) findViewById(R.id.spaCount);
        pizzaCheck = (CheckBox) findViewById(R.id.pizzaOrder);
        spaCheck = (CheckBox) findViewById(R.id.spaOrder);

        pizzaCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(pizzaCheck.isChecked()) {
                    pizzaUp.setEnabled(true);
                    pizzaDown.setEnabled(true);
                }else{
                    pizzaCount = 0;
                    pizzaView.setText("피자 = "+pizzaCount);
                    pizzaUp.setEnabled(false);
                    pizzaDown.setEnabled(false);
                }

            }
        });

        spaCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(spaCheck.isChecked()) {
                    spaUp.setEnabled(true);
                    spaDown.setEnabled(true);
                }else{
                    spaCount = 0;
                    spaView.setText("스파게티 = "+spaCount);
                    spaUp.setEnabled(false);
                    spaDown.setEnabled(false);
                }
            }
        });

        pizzaUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pizzaCount++;

                pizzaView.setText("피자 = "+pizzaCount);
            }
        });

        pizzaDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pizzaCount>0)
                    pizzaCount--;
                pizzaView.setText("피자 = "+pizzaCount);
            }
        });

        spaUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spaCount++;

                spaView.setText("스파게티 = "+spaCount);
            }
        });

        spaDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spaCount>0)
                    spaCount--;

                spaView.setText("스파게티 = "+spaCount);
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT", pizzaView.getText().toString() + ","+spaView.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
