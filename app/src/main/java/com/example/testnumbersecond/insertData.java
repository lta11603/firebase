package com.example.testnumbersecond;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insertData extends AppCompatActivity {
    FirebaseDatabase database;
    private EditText nameproduct,products,price,image;
    private Button btnInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        nameproduct = findViewById(R.id.nameProduct);
        products = findViewById(R.id.products);
        price = findViewById(R.id.price);
        image = findViewById(R.id.image);
        btnInsert = findViewById(R.id.btn_insert);
        database = FirebaseDatabase.getInstance();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensp = nameproduct.getText().toString();
                String loaisp = products.getText().toString();
                String giasp = price.getText().toString();
                String anhsp = image.getText().toString();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("products");
                databaseReference.child("sanpham1").child("anhsp").setValue(anhsp);
                databaseReference.child("sanpham1").child("giasp").setValue(giasp);
                databaseReference.child("sanpham1").child("loaisp").setValue(loaisp);
                databaseReference.child("sanpham1").child("tensp").setValue(tensp);

                Toast.makeText(insertData.this,"insert success",Toast.LENGTH_SHORT).show();
            }
        });

    }
}