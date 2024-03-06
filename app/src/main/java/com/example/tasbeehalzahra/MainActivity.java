package com.example.tasbeehalzahra;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer n=0;
    int seq=1;
    private static final int  max_first = 34;
    private static final int max_second = 33;
    private ImageButton incr;
    private TextView text;
    private TextView text1;
    private Boolean reset=false;
    private String []tsbeehat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incr=findViewById(R.id.button);
        text=findViewById(R.id.textView);
        text1=findViewById(R.id.textView1);
        tsbeehat = new String[]{getString(R.string.Akber), getString(R.string.Alhamd), getString(R.string.Sphan)};

        incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                switch(seq){
                    case 1:
                        PrintString(tsbeehat[0]);
                        if (n==max_first)
                        {
                            seq++;
                            n=0;
                            PrintString(tsbeehat[1]);
                        }
                        break;
                    case 2:
                        if (n==max_second)
                        {
                            seq++;
                            n=0;
                            PrintString(tsbeehat[2]);
                        }
                        break;
                    case 3:
                        if (n==max_second)
                        {
                            n=0;
                            seq=0;
                            Toast.makeText(MainActivity.this, getString(R.string.finish), Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(MainActivity.this,Return.class);
                            startActivity(intent);
                        }
                        break;
                }
                if (seq!=0)
                    PrintnNumber(n);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        PrintnNumber(n);
        PrintString(tsbeehat[0]);
    }

    public void PrintString(String s)
    {
        text.setText(s);
    }
    public void PrintnNumber(Integer n)
    {
        text1.setText(n.toString());
    }

}