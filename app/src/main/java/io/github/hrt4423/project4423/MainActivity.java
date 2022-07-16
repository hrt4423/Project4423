package io.github.hrt4423.project4423;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //ImageViewクラスの変数
    private ImageView myChar;
    private ImageView enemy;
    private ImageView e_bullet;
    private ImageView mc_bullet;
    private TextView startLabel;
    private boolean start_flg;

    private  int frameHeight;
    private  int frameWidth;
    private  int screenWidth;

    private  int myCharSpeed;
    private  float myCharX;
    private int myCharSize;

    private int enemySpeed;
    private float enemyX, enemyY;
    private int enemySize;

    private  boolean action_flg = false;

    private Timer timer = new Timer();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {//引数：アプリの状態情報
        super.onCreate(savedInstanceState);//親クラスのメソッドを呼び出しておく。
        setContentView(R.layout.activity_main);//画面に表示すべきビューを設定する。


        //findViewByIdでactivity_mainで設定したidからviewを探す。
        myChar = findViewById(R.id.mychar);
        enemy = findViewById(R.id.enemy_mob3);
        e_bullet = findViewById(R.id.attack_effect_enemy);
        mc_bullet = findViewById(R.id.attack_effect_mychar);
        startLabel = findViewById(R.id.startLabel);

        //画面の横幅の取得
        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay(); //画面のサイズの取得
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;


        //スピードの設定
        myCharSpeed = Math.round(screenWidth / 60f);
        enemySpeed = Math.round(screenWidth/ 60f);

        //setX setY メソッドで座標を設定
        enemy.setX(450.0f);
        enemy.setY(250.0f);
        e_bullet.setX(500.0f);
        e_bullet.setY(400.0f);

        myChar.setX(450.0f);
        myChar.setY(1500.0f);
        mc_bullet.setX(500.0f);
        mc_bullet.setY(1500.0f);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!start_flg){
            start_flg = true;

            //レイアウトの高さを取得
            FrameLayout frame = findViewById(R.id.frame);
            frameHeight = frame.getHeight();
            frameWidth  = frame.getWidth();

            //myChar座標の取得
            myCharX = myChar.getX();
            //myCharサイズの取得
            myCharSize = myChar.getWidth();
            //enemy座標の取得
            enemyX = enemy.getX();
            enemySize = enemy.getWidth();


            startLabel.setVisibility(View.GONE);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() { //handlerにRunnableを渡してUIを更新する。
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            }, 0, 20);

            //タッチしているかの判定
        } else { //start_flg = true
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                action_flg = true;

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                action_flg = false;

            }
        }
        return true;
    }

    public void changePos(){
        hitCheck();

        //Enemy 変化量を決めてる
        enemyX -= enemySpeed;

        //画面外に出たときの処理
        if (enemyX < -enemySize) {
            enemyX = screenWidth  + 20;
            /*Y座標は、0 から frameHeight – orange.getHeight() の範囲のランダムな値。
            enemyY = (float)Math.floor(Math.random() * (frameHeight - enemy.getHeight()));
            */
        }

        //値の更新
        enemy.setX(enemyX);
        //enemy.setY(enemyY);


        //MyChar
        if (action_flg) {
            myCharX -= myCharSpeed;
        } else {
            myCharX += myCharSpeed;
        }
        //frameの中にいるかの判定
        if (myCharX < 0) myCharX = 0;

        if (myCharX > frameWidth - myCharSize) myCharX = frameWidth - myCharSize;

        myChar.setX(myCharX);

    }

    public void hitCheck(){

    }

    //バックボタン無効化
    @Override
    public void onBackPressed() { }

    //これは平田の作業だ。

}

