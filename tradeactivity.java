package com.example.tradebud2;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class tradeactivity extends AppCompatActivity {
    private String tradeno;
    private TextView q1;
    private static final int GalleryPick2 = 1;
    private EditText we1, we2;
    private ImageView im1;
    private Button Trabutt;
    private Uri ImageUri1;
    String Traname,Tradesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradeactivity);
        q1 = findViewById(R.id.ttextview1);
        we1 = findViewById(R.id.tedittext1);
        we2 = findViewById(R.id.tedittext2);
        im1 = findViewById(R.id.tSelect_product_image);
        Trabutt = findViewById(R.id.Tbutton);


        tradeno = getIntent().getStringExtra("keyname");
        q1.setText(tradeno);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenGallery();
            }
        });

        Trabutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validatedata();
            }
        });


    }


    private void OpenGallery() {
        Intent galleryintent = new Intent();
        galleryintent.setAction(Intent.ACTION_GET_CONTENT);
        galleryintent.setType("image/*");
        startActivityForResult(galleryintent, GalleryPick2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GalleryPick2 && resultCode == RESULT_OK && data != null) {
            ImageUri1 = data.getData();
            im1.setImageURI(ImageUri1);
        }
    }



    private void Validatedata()
    {

        Traname=we1.getText().toString();
        Tradesc=we2.getText().toString();


        if(ImageUri1 == null){
            Toast.makeText(tradeactivity.this, "Product Image Needed", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Tradesc)){
            Toast.makeText(tradeactivity.this, "Please give Discription", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Traname)){
            Toast.makeText(tradeactivity.this, "Please give Trade item", Toast.LENGTH_SHORT).show();
        }
        else{


            String newpath = "Product Order = "+tradeno;
            String newpath1="Product Offered for trade ="+Traname;
            String newpath2="Product Description ="+Tradesc;
            String total = newpath+"/n"+newpath1+"/n"+newpath2;

            final String username ="tradeBud22@gmail.com";
            final String password ="zxcvbnm@1234";
            String messageTosend =total;

            Intent intent=new Intent((Intent.ACTION_SEND));
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{username});
            intent.putExtra(Intent.EXTRA_TEXT,messageTosend);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Order Placed");

            intent.setType("message/rfc822");
            startActivity(intent);



        }
    }





    }
