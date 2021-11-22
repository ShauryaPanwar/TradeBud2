package com.example.tradebud2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Inputname;
    private EditText InputPassword;
    private TextView Info;
    private Button login;
    private Button Register;
    private String Dbname = "Users";
    private String phone;
    private Button adminbutt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inputname = (EditText)findViewById(R.id.etusername);
        InputPassword = (EditText) findViewById(R.id.etpassword);

        login = (Button) findViewById(R.id.button);
        adminbutt = (Button)findViewById(R.id.adminbutt);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginusr();
            }

            private void loginusr()
            {
                phone = Inputname.getText().toString();
                String password = InputPassword.getText().toString();

                AllowaccesstoAcoount(phone , password);

            }

            private void AllowaccesstoAcoount(String phone, String password)
            {

                if(phone.equals("6376240259") && password.equals("1234")){
                    Intent intent = new Intent(MainActivity.this,Homepage.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this,Homepage.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "hmmm", Toast.LENGTH_SHORT).show();

                }
            }
        });

        Register = (Button) findViewById(R.id.Reister_here);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,register_activity.class);
                startActivity(intent);
            }
        });
        adminbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Admincategoryactivity.class);
                startActivity(intent);
            }
        });







    }




}