package com.example.sandeshbafna.image;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button flower=(Button)findViewById(R.id.flower);
        Button leaf=(Button)findViewById(R.id.leaf);
        Button petel=(Button)findViewById(R.id.petel);
        final Intent intent = new Intent(this,Main2Activity.class);

        flower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("pass",1);
                startActivity(intent);
            }
        });
        leaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            intent.putExtra("pass",2);
                startActivity(intent);
            }
        });
        petel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("pass",3);
                startActivity(intent);
            }
        });
    }
}