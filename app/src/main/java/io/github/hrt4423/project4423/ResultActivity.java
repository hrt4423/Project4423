package io.github.hrt4423.project4423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findViewById(R.id.mychar).startAnimation(AnimationUtils.loadAnimation(this, R.anim.a1));

        TextView scoreLabel = findViewById(R.id.scoreLabel);
        TextView highScoreLabel = findViewById(R.id.highScoreLabel);
        TextView tryLabel = findViewById(R.id.tryLabel);
        TextView overLabel = findViewById(R.id.overLabel);


        //フォントの設定
        Typeface customFont = Typeface.createFromAsset(getAssets(), "PixelMplus10-Regular.ttf");
        scoreLabel.setTypeface(customFont);
        highScoreLabel.setTypeface(customFont);
        tryLabel.setTypeface(customFont);
        overLabel.setTypeface(customFont);

        int score = getIntent().getIntExtra("SCORE", 0);
        scoreLabel.setText(score + "");

        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", MODE_PRIVATE);
        int highScore = sharedPreferences.getInt("HIGH_SCORE", 0);

        if (score > highScore) {
            highScoreLabel.setText("New High Score : " + score);
            //音を追加する
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.apply();

        } else {
            highScoreLabel.setText("High Score : " + highScore);
        }
    }

    public void tryAgain(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    //バックボタン無効化
    @Override
    public void onBackPressed() { }
}