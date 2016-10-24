package com.example.vijayrajbafna.scramsdie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int ucs, uts = 0, ccs, cts = 0, turn,rollclick=0,lol;
    private TextView total;
    private TextView current;
    private ImageView die;
    private TextView status;
    private Button restart;
    private Button back;
    private Random random=new Random();
    private LinearLayout buttons;
    private Button helper;
    private Handler handle=new Handler();
    Runnable tunner = new Runnable() {
        int turn=0;
        @Override
        public void run() {
            int x = random.nextInt(5)+1;
            handle(x);
            buttons.setVisibility(View.INVISIBLE);
            if (x == 1) {
                ccs = 0;
                helper.setVisibility(View.VISIBLE);
                buttons.setVisibility(View.VISIBLE);
                status.setText(R.string.comp_failed);
                display();
                return;
            } else
                ccs = ccs + x;
            turn++;

            if (ccs <= 20) {
                current.setText("computer rolle= "+turn+"    computer turn score= "+ccs);
                handle.postDelayed(this, 500);
            } else {
                cts = cts + ccs;
                ccs = 0;
                display();
                if (cts >= 100) {
                    status.setText(R.string.comp_wins);
                    restart.setVisibility(View.VISIBLE);
                    buttons.setVisibility(View.INVISIBLE);
                    helper.setVisibility(View.INVISIBLE);
                }else{
                    buttons.setVisibility(View.VISIBLE);
                    status.setText(R.string.user_turn);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = (TextView) findViewById(R.id.overall);
        current = (TextView) findViewById(R.id.currentturn);
        die = (ImageView) findViewById(R.id.image);
        Button roll = (Button) findViewById(R.id.roll);
        Button hold = (Button) findViewById(R.id.hold);
        Button reset = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);
        restart = (Button) findViewById(R.id.restart);
        restart.setVisibility(View.INVISIBLE);
        status.setText(R.string.user_turn);
        buttons=(LinearLayout)findViewById(R.id.buttons);
        back=(Button)findViewById(R.id.back);
        helper=(Button)findViewById(R.id.helper);
        back.setVisibility(View.INVISIBLE);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollclick=1;
                status.setText(R.string.user_turn);
                turn++;
                int x = random.nextInt(5)+1;
                handle(x);
                if(x==1){
                    ucs=0;
                    turn=0;
                    buttons.setVisibility(View.INVISIBLE);
                    computerturn();
                    helper.setVisibility(View.VISIBLE);
                }else ucs=ucs+x;
                display();
            }
        });
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rollclick==0){
                    current.setText(R.string.noroll_condition);
                    return;
                }
                uts = uts + ucs;
                ucs=0;
                turn=0;
                buttons.setVisibility(View.INVISIBLE);
                if(uts>=100){
                    status.setText("you reached 100 first\nyou win wow");
                    restart.setVisibility(View.VISIBLE);
                    helper.setVisibility(View.INVISIBLE);
                    display();
                } else {
                    computerturn();
                    rollclick = 0;
                }
                display();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uts=0;
                ucs=0;
                cts=0;
                ccs=0;
                turn=0;
                rollclick=0;
                helper.setVisibility(View.VISIBLE);
                restart.setVisibility(View.INVISIBLE);
                buttons.setVisibility(View.VISIBLE);
                status.setText(R.string.user_turn);
                display();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart.callOnClick();
            }
        });
    }
    public void computerturn() {
        ccs = 0;
        turn = 0;
        status.setText(R.string.processing_compturn);
        handle.postDelayed(tunner,1000);
        display();
    }
    public void helper(View view){
        total.setVisibility(View.INVISIBLE);
        current.setVisibility(View.INVISIBLE);
        buttons.setVisibility(View.INVISIBLE);
        back.setVisibility(View.VISIBLE);
        helper.setVisibility(View.INVISIBLE);
        status.setText(R.string.instruction);
    }
    public void back(View view){
        total.setVisibility(View.VISIBLE);
        current.setVisibility(View.VISIBLE);
        buttons.setVisibility(View.VISIBLE);
        back.setVisibility(View.INVISIBLE);
        helper.setVisibility(View.VISIBLE);
        status.setText(R.string.user_turn);
    }
    public void handle(int x){
        switch (x) {
            case 1:
                die.setImageResource(R.drawable.dice1);
                break;
            case 2:
                die.setImageResource(R.drawable.dice2);
                break;
            case 3:
                die.setImageResource(R.drawable.dice3);
                break;
            case 4:
                die.setImageResource(R.drawable.dice4);
                break;
            case 5:
                die.setImageResource(R.drawable.dice5);
                break;
            default:
                die.setImageResource(R.drawable.dice6);
                break;
        }
    }
    public void display(){
        total.setText("your scr= " + uts + "   computer scr= " + cts);
        current.setText("u rolled " + turn + " times                current turn score = " + ucs + "                press hold to add current score to total");
    }
}
