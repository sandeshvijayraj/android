package com.example.sandeshbafna.image;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView image = (ImageView) findViewById(R.id.image);
        Button grid=(Button)findViewById(R.id.grid);

        Bundle x = getIntent().getExtras();
        int y = x.getInt("pass");
        switch (y) {
            case 1:
                image.setImageResource(R.drawable.a1);
                break;
            case 2:
                image.setImageResource(R.drawable.b2);
                break;
            default:
                image.setImageResource(R.drawable.c3);
                break;
        }
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}