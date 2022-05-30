package com.example.ice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtDesc;
    Button btnAdd;
    ImageView imgFruit;

    FruitObj fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
        
        setClickListeners();
    }

    private void setClickListeners() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String desc = edtDesc.getText().toString();
                fruit = new FruitObj(name, desc);
                Intent i = new Intent(getApplicationContext(), View_Fruit.class);
                i.putExtra("name", name);
                i.putExtra("desc", desc);

            }
        });
    }

    private void setUpUI() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtDesc = (EditText) findViewById(R.id.edtDesc);
        btnAdd = (Button) findViewById(R.id.btnAddNew);
        imgFruit = (ImageView) findViewById(R.id.imgFruit);
    }
}