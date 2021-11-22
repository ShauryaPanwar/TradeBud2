package com.example.tradebud2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Admincategoryactivity extends AppCompatActivity {
    private ImageView books,phone,shoe;
    private ImageView headphone,keyboard,shirt;
    private ImageView bag,toolkit,laptop;
    private ImageView glasses,games,services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincategoryactivity);

        books=(ImageView) findViewById(R.id.hp_book);
        phone=(ImageView) findViewById(R.id.samsung);
        shoe=(ImageView) findViewById(R.id.shoe);
        headphone=(ImageView) findViewById(R.id.headphones);
        keyboard=(ImageView) findViewById(R.id.keyboard);
        shirt=(ImageView) findViewById(R.id.shirt);
        bag=(ImageView) findViewById(R.id.bag);
        toolkit=(ImageView) findViewById(R.id.Toolkit);
        laptop=(ImageView) findViewById(R.id.Hplaptop);
        glasses=(ImageView) findViewById(R.id.glasses);
        games=(ImageView) findViewById(R.id.Gta);
        services=(ImageView) findViewById(R.id.services);



        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","books");
                startActivity(intent);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","phones");
                startActivity(intent);
            }
        });
        shoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","shoe");
                startActivity(intent);
            }
        });
        headphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","headphone");
                startActivity(intent);
            }
        });
        keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","keyboards");
                startActivity(intent);
            }
        });
        shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","shirt");
                startActivity(intent);
            }
        });
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","bag");
                startActivity(intent);
            }
        });
        toolkit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","toolkit");
                startActivity(intent);
            }
        });
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","laptop");
                startActivity(intent);
            }
        });
        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","glasses");
                startActivity(intent);
            }
        });
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","games");
                startActivity(intent);
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admincategoryactivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","services");
                startActivity(intent);
            }
        });

    }
}