package io.github.hrt4423.project4423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findViewById(R.id.mychar).startAnimation(AnimationUtils.loadAnimation(this, R.anim.a1));

        Typeface customFont = Typeface.createFromAsset(getAssets(), "PixelMplus10-Regular.ttf");
        TextView myText = findViewById(R.id.myText);
        TextView btntext = findViewById(R.id.btntext);
        myText.setTypeface(customFont);
        btntext.setTypeface(customFont);

        // クリックリスナーをセット
        findViewById(R.id.btntext).setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

        if(v.getId() == R.id.btntext){
            overridePendingTransition(android.R.anim.slide_in_right, android.R.anim.slide_out_left);

        }
    }
}