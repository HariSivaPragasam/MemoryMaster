package com.example.siva.memorymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {


    public Button btn_start;

    public void start(){
        btn_start = (Button)findViewById(R.id.btn_start);
        final MediaPlayer soundstart = MediaPlayer.create(this, R.raw.sm64_mario_lets_go);

        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Start.class);
                startActivity(intent);
                soundstart.start();


            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView)findViewById(R.id.image_start);

        start();



    }


}
