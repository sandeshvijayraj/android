package com.example.sandeshbafna.greetingcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    String bboy;
    String myname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView wish=(TextView)findViewById(R.id.wish);
        TextView from=(TextView) findViewById(R.id.from);
        Bundle intent=getIntent().getExtras();

        bboy=intent.getString("bb");
        myname=intent.getString("my");

            wish.setText("hey, "+bboy+" wish you");
            from.setText("from "+myname+"  ");
    }
}
