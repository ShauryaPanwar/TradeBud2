package com.example.tradebud2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Homepage extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mtollbar;

    Button butt1;
    Button butt2;
    Button butt7;
    Button butt3;
    Button butt4;
    Button butt5;
    Button butt6;
    String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        mtollbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mtollbar);


        butt1=findViewById(R.id.Tbutt1);
        butt2=findViewById(R.id.Tbutt2);
        butt3=findViewById(R.id.Tbutt3);
        butt4=findViewById(R.id.Tbutt4);
        butt5=findViewById(R.id.Tbutt5);
        butt6=findViewById(R.id.Tbutt6);
        butt7=findViewById(R.id.Tbutt7);


        butt1.setOnClickListener(this);
        butt2.setOnClickListener(this);
        butt3.setOnClickListener(this);
        butt4.setOnClickListener(this);
        butt5.setOnClickListener(this);
        butt6.setOnClickListener(this);
        butt7.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Tbutt1:
                Intent intent = new Intent(Homepage.this,tradeactivity.class);

                x="Trade number 1 is approached";
                intent.putExtra("keyname",x);
                startActivity(intent);
                break;
            case R.id.Tbutt2:
                Intent intent2 = new Intent(Homepage.this,tradeactivity.class);

                x="Trade number 2 is approached";
                intent2.putExtra("keyname",x);
                startActivity(intent2);
                break;
            case R.id.Tbutt3:
                Intent intent3 = new Intent(Homepage.this,tradeactivity.class);

                x="Trade number 3 is approached";
                intent3.putExtra("keyname",x);
                startActivity(intent3);
                break;
            case R.id.Tbutt4:
                Intent intent4 = new Intent(Homepage.this,tradeactivity.class);

                x="Trade number 4 is approached";
                intent4.putExtra("keyname",x);
                startActivity(intent4);
                break;

            case R.id.Tbutt5:
                Intent intent5 = new Intent(Homepage.this,tradeactivity.class);

                x="Trade number 5 is approached";
                intent5.putExtra("keyname",x);
                startActivity(intent5);
                break;
            case R.id.Tbutt6:
                Intent intent6 = new Intent(Homepage.this,tradeactivity.class);

                x="Trade number 6 is approached";
                intent6.putExtra("keyname",x);
                startActivity(intent6);
                break;
            case R.id.Tbutt7:
                Intent intent7 = new Intent(Homepage.this,tradeactivity.class);

                x="Trade number 7 is approached";
                intent7.putExtra("keyname",x);
                startActivity(intent7);
                break;


        }
    }
}