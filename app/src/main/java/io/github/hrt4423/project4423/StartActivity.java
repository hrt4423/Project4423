package io.github.hrt4423.project4423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

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

    }

    public void startGame(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}