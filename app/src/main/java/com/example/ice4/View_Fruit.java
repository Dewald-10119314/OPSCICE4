package com.example.ice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class View_Fruit extends AppCompatActivity {
    TextView txtName, txtDesc;
    ImageView imgFruit;
    Button btnImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fruit);

        setUpUI();

        setUpClickListeners();
    }

    private void setUpClickListeners() {
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setUpUI() {
        txtName = (TextView) findViewById(R.id.txtName);
        txtDesc = (TextView) findViewById(R.id.txtDesc);
        imgFruit = (ImageView) findViewById(R.id.imgFruit);
        btnImage = (Button) findViewById(R.id.btnImage);

        Intent i = getIntent();
        txtName.setText(i.getStringExtra("name"));
        txtDesc.setText(i.getStringExtra("desc"));
        imgFruit.setImageBitmap(MainActivity.fruit.getImgBMP());
    }
}