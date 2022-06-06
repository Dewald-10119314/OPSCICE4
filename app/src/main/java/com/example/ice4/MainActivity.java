package com.example.ice4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtDesc;
    Button btnAdd;
    ImageView imgFruit;

    ActivityResultLauncher<Intent> resultLauncher;
    public static FruitObj fruit;
    Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
        
        setClickListeners();
    }

    private void setClickListeners() {
        //AR Launcher (The IIE, 2022)
        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Bundle imgBundle = result.getData().getExtras();
                if (imgBundle != null){
                    img = (Bitmap) imgBundle.get("data");
                    imgFruit.setImageBitmap(img);
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img != null){
                    String name = edtName.getText().toString();
                    String desc = edtDesc.getText().toString();
                    fruit = new FruitObj(name, desc, img);
                    Intent i = new Intent(getApplicationContext(), View_Fruit.class);
                    i.putExtra("name", name);
                    i.putExtra("desc", desc);
                    i.putExtra("img", img);
                }

            }
        });

        imgFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageHandler();
            }
        });
    }

    private void setUpUI() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtDesc = (EditText) findViewById(R.id.edtDesc);
        btnAdd = (Button) findViewById(R.id.btnAddNew);
        imgFruit = (ImageView) findViewById(R.id.imgFruit);
    }

    public void ImageHandler(){
        Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        resultLauncher.launch(i);
    }
}