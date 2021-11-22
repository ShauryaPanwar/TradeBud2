package com.example.tradebud2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register_activity extends AppCompatActivity {
    private Button Registerin;
    private EditText Inputname,Inputnumber,InputPassword;
    private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Registerin = (Button) findViewById(R.id.register_button);
        Inputname = (EditText) findViewById(R.id.register_name);
        Inputnumber = (EditText) findViewById(R.id.register_number);
        InputPassword = (EditText) findViewById(R.id.register_password);
        loadingbar = new ProgressDialog(this);
        Registerin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Registerin();
            }

            private void Registerin() {
                String regname = Inputname.getText().toString();
                String regnum = Inputnumber.getText().toString();
                String regpass = InputPassword.getText().toString();
                if(TextUtils.isEmpty(regname)){
                    Toast.makeText(register_activity.this,"Please write your name", Toast.LENGTH_SHORT).show();

                }
                else if(TextUtils.isEmpty(regnum)){
                    Toast.makeText(register_activity.this,"Please write your phone number", Toast.LENGTH_SHORT).show();

                }
                else if(TextUtils.isEmpty(regpass)){
                    Toast.makeText(register_activity.this,"Please write your password", Toast.LENGTH_SHORT).show();

                }
                else{
                    loadingbar.setTitle("Creating account");
                    loadingbar.setMessage("Please Wait ");
                    loadingbar.setCanceledOnTouchOutside(false);
                    loadingbar.show();

                    Validatephonemunber(regname,regnum,regpass);
                }
            }

            private void Validatephonemunber(String regname, String regnum, String regpass) {
            }


        });



    }

}