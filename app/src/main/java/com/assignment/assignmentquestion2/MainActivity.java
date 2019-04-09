package com.assignment.assignmentquestion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button submit;
    private EditText number,result;

    private static final String [] ones={"zero","one","two","three","four"," five",
            " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen",
            " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
    private static final String[] tens = { "", " ten", " twenty", " thirty", " forty",
            " fifty", " sixty", " seventy", " eighty", " ninety" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number=findViewById(R.id.et_number);
        result=findViewById(R.id.et_result);
        submit=findViewById(R.id.btn_submit);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Integer convertnumber=Integer.parseInt(number.getText().toString());

        if (convertnumber<20){
            result.setText(ones[convertnumber]);
        }


        else if(convertnumber<100) {
            int tensIndex = convertnumber / 10;
            int onesIndex = convertnumber % 10;

            if (onesIndex != 0) {
                result.setText(tens[tensIndex] + " " + ones[onesIndex]);
            } else {
                result.setText(tens[tensIndex]);
            }
        }
        else {
            int hundredsIndex = convertnumber / 100;
            int remainder = convertnumber % 100;
            int tensIndex = remainder / 10;
            int onesIndex = remainder % 10;

            if (onesIndex != 0){
                result.setText(ones[hundredsIndex]+" hundred "+tens[tensIndex]+" "+ones[onesIndex]);
            }else{
                result.setText(ones[hundredsIndex]+" hundred "+tens[tensIndex]);
            }
        }
    }


    }

