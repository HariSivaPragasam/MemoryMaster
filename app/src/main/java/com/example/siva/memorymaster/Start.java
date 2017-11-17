package com.example.siva.memorymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.media.MediaPlayer;
import java.util.Random;


public class Start extends AppCompatActivity {

    ImageView img_question, img_answer;
    Button btn_answer;

    int array_images[] = new int[]{

            R.drawable.chinchilla_icon,
            R.drawable.monkey_icon,
            R.drawable.owl_icon,
            R.drawable.giraffe_icon,
            R.drawable.bird_icon,
            R.drawable.cow_icon,
            R.drawable.elephant_icon,
            R.drawable.panda_icon,
            R.drawable.dog_icon
    };

    int correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Memory Master");
        setSupportActionBar(toolbar);

        img_question = (ImageView) findViewById(R.id.img_question);

        btn_answer = (Button) findViewById(R.id.btn_answer);
        btn_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Start.this, ChooseAnswer.class);
                startActivityForResult(intent, 1999);
            }
        });

        randomImage();
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            final MediaPlayer win = MediaPlayer.create(this, R.raw.win);
            final MediaPlayer lose = MediaPlayer.create(this,R.raw.lose);


            if (requestCode == 1999)
            {
                int answer_resource_id = data.getIntExtra("Answer", 0);
                img_answer = (ImageView)findViewById(R.id.img_answer);
                img_answer.setImageResource(answer_resource_id);

                if (answer_resource_id == correct_answer)
                {
                    win.start();
                    Toast.makeText(this, "Great ! You have a Master Memory !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    lose.start();
                    Toast.makeText(this, "Oops ! You forgot ! :( ", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.menu_re_new:
                    randomImage();
                    img_answer = (ImageView)findViewById(R.id.img_answer);
                    img_answer.setImageResource(R.drawable.no_icon);
                    break;
            }
            return true;
        }

    private void randomImage() {
        int img_resource = array_images[new Random().nextInt(9)];
        img_question.setImageResource(img_resource);

        correct_answer = img_resource;
    }
}



