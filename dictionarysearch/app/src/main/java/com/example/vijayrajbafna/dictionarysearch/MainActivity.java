package com.example.vijayrajbafna.dictionarysearch;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> as;
    private HashMap<Character,ArrayList<String>> hm=new HashMap<>();

    public void getFile(InputStream is) throws IOException{
        BufferedReader bs=new BufferedReader(new InputStreamReader(is));
        String line;
        while((line =bs.readLine())!=null){
            String s=line.trim();
            as.add(s);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        as=new ArrayList<String>();
        setContentView(R.layout.activity_main);
        final ListView lv=(ListView)findViewById(R.id.items);
        final EditText et=(EditText)findViewById(R.id.searchbox);
        AssetManager al=getAssets();
        try{
            InputStream is=al.open("words.txt");
            getFile(is);

        } catch (IOException e) {
            Toast toast= Toast.makeText(this,"unable to load dictionary",Toast.LENGTH_SHORT);
            toast.show();
        }
        int n=as.size();
        for(char c='a';c<='z';c++){
            ArrayList<String> temp=new ArrayList<>();
            hm.put(c,temp);
        }
        for(int i=0;i<n;i++){
        char[] s=as.get(i).toCharArray();
            hm.get(s[0]).add(as.get(i));
        }
        final ListAdapter adapter= new ArrayAdapter<String>(this,R.layout.text_view_handler,R.id.bla, as);
        lv.setAdapter(adapter);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            public void afterTextChanged(Editable editable) {
                char[] s;
                ArrayList<String> temp2=new ArrayList<>();
                s =et.getText().toString().toLowerCase().toCharArray();
                if(s.length!=0) {
                    String st = new String(s);
                    for (int x = 0; x < hm.get(s[0]).size(); x++) {
                        if (hm.get(s[0]).get(x).toLowerCase().regionMatches(0, st, 0, st.length())) {
                            temp2.add(hm.get(s[0]).get(x));
                        }
                    }

                    ListAdapter tempadp = new ArrayAdapter<>(getApplicationContext(),R.layout.text_view_handler,R.id.bla, temp2);
                    lv.setAdapter(tempadp);
                }else{
                    lv.setAdapter(adapter);
                }
            }
        });
    }
}