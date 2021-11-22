package com.example.tradebud2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class AdminAddnewProduct extends AppCompatActivity {
    private String Categoryname,Description,Trade,Pname,savecurrentdate,savecurrenttime;
    private Button AddnewProductButton;
    private ImageView InputProductImage;
    private EditText InputProductname,InputProductdescrition,InputProductTrade;
    private static final int GalleryPick=1;
    private Uri ImageUri;
    private String productrandomkey , downloadimageurl;
    private StorageReference ProductImagesRef;
    private DatabaseReference Productref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_addnew_product);

        Categoryname=getIntent().getExtras().get("category").toString();
        ProductImagesRef= FirebaseStorage.getInstance().getReference().child("Product Images");
        Productref = FirebaseDatabase.getInstance().getReference().child("Products");

        Toast.makeText(AdminAddnewProduct.this,Categoryname, Toast.LENGTH_SHORT).show();

        AddnewProductButton=(Button) findViewById(R.id.add_new_product);
        InputProductImage=(ImageView) findViewById(R.id.Select_product_image);
        InputProductname=(EditText) findViewById(R.id.product_name);
        InputProductdescrition=(EditText) findViewById(R.id.product_description);
        InputProductTrade=(EditText) findViewById(R.id.product_trade);

        InputProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenGallery();
            }
        });
        AddnewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateProductData();
            }
        });
    }

    private void OpenGallery() {
        Intent galleryintent = new Intent();
        galleryintent.setAction(Intent.ACTION_GET_CONTENT);
        galleryintent.setType("image/*");
        startActivityForResult(galleryintent,GalleryPick);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==GalleryPick && resultCode==RESULT_OK && data!=null){
            ImageUri=data.getData();
            InputProductImage.setImageURI(ImageUri);

        }

    }

    private void ValidateProductData(){

        Description=InputProductdescrition.getText().toString();
        Trade=InputProductTrade.getText().toString();
        Pname=InputProductname.getText().toString();

        if(ImageUri == null){
            Toast.makeText(AdminAddnewProduct.this, "Product Image Needed", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Description)){
            Toast.makeText(AdminAddnewProduct.this, "Please give Discription", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Trade)){
            Toast.makeText(AdminAddnewProduct.this, "Please give Trade item", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Pname)){
            Toast.makeText(AdminAddnewProduct.this, "Please give Name", Toast.LENGTH_SHORT).show();
        }
        else{
            StoreImageInformation();
        }

    }

    private void StoreImageInformation() {

        Calendar calendar= Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyy");
        savecurrentdate=currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        savecurrenttime=currentTime.format(calendar.getTime());

        productrandomkey = savecurrentdate + savecurrenttime;

        StorageReference filePath = ProductImagesRef.child(ImageUri.getLastPathSegment()+productrandomkey+".jpg");

        final UploadTask uploadTask = filePath.putFile(ImageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String message =e.toString();
                Toast.makeText(AdminAddnewProduct.this, "Error:"+message, Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
            {
                Toast.makeText(AdminAddnewProduct.this, "Image Uploaded sucessfully", Toast.LENGTH_SHORT).show();

                Task<Uri>urlTask= uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception
                    {
                        if(!task.isSuccessful()){
                            throw task.getException();

                        }

                        downloadimageurl=filePath.getDownloadUrl().toString();
                        return filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if(task.isSuccessful()){
                            downloadimageurl = task.getResult().toString();
                            Toast.makeText(AdminAddnewProduct.this, "Getting product Image Url success", Toast.LENGTH_SHORT).show();

                            SaveProductInfoToDatabase();
                        }
                    }
                });
            }
        });
    }

    private void SaveProductInfoToDatabase()
    {
        HashMap<String,Object>productMap=new HashMap<>();
        productMap.put("Productid",productrandomkey);
        productMap.put("date",savecurrentdate);
        productMap.put("Time",savecurrenttime);
        productMap.put("description",Description);
        productMap.put("image",downloadimageurl);
        productMap.put("category",Categoryname);
        productMap.put("Trade item",Trade);
        productMap.put("Product name",Pname);

        Productref.child(productrandomkey).updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(AdminAddnewProduct.this,Admincategoryactivity.class);
                    startActivity(intent);
                    Toast.makeText(AdminAddnewProduct.this, "Product added sucessfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    String message = task.getException().toString();
                    Toast.makeText(AdminAddnewProduct.this, "Error: "+message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}