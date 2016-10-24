package com.example.sandeshbafna.orders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int s=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sub = (Button) findViewById(R.id.subtract);
        Button plus = (Button) findViewById(R.id.plus);
        Button buy = (Button) findViewById(R.id.buy);
        final TextView people = (TextView) findViewById(R.id.peoples1);
        final TextView totalval = (TextView) findViewById(R.id.totalvalue);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s != 0) {
                    people.setText("" + (--s));
                    totalval.setText("" + (s * 50));
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.setText("" + (++s));
                totalval.setText("" + (s * 50));
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buy1();
            }
        });
    }

        public void buy1() {
        Intent next = new Intent(this, Main2Activity.class);
        startActivity(next);
    }
    }
