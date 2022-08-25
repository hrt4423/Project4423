package io.github.hrt4423.project4423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //インスタンス

     public Enemy1Data eData1 = new Enemy1Data();
     public Enemy1Data eData2 = new Enemy1Data();
     public Enemy1Data eData3 = new Enemy1Data();
     public FrameData fData = new FrameData();
     public Enemy3 enemy1 = new Enemy3();
     public Enemy2 enemy2 = new Enemy2();
     public Enemy4 enemy3 = new Enemy4();
     public BulletData bData1 = new BulletData();
     public Enemy1Bullet e1Bullet = new Enemy1Bullet();
     public MyChar1 myChar1 = new MyChar1();
     public MyCharData mcData = new MyCharData();


    //変数
    //ImageViewクラスの変数
    private ImageView myChar;
    private ImageView enemy;
    private ImageView enemyth;
    private ImageView enemyth2;
    private ImageView e_bullet;
    private ImageView mc_bullet;
    private TextView startLabel;
    private TextView scoreLabel;
    private boolean start_flg;

    private  int frameHeight;
    private  int screenWidth;

    private int score = 0;

    //自キャラ
    private  int myCharSpeed;
    private  float myCharX, myCharY;
    private int myCharWidth, myCharHeight;

    //敵キャラ
    /*
        private int enemySpeed;
        private float enemyX, enemyY;
        private int enemySize;
     */


    //弾　自キャラ
    private int mc_bulletSpeed;
    private float mc_bulletX, mc_bulletY;
    private int mc_bulletSize;

    //弾　敵キャラ
    private  int e_bulletSpeed;
    private float e_bulletX, e_bulletY;
    private int e_bulletSize;

    //自キャラと弾のずれ補正値
    private int mcBCorrection = 56;
    private int eBCorrectionX = 47;
    private int eBCorrectionY = 150;

    private  boolean action_flg = false;

    private Timer timer = new Timer();
    private Handler handler = new Handler();

    // Sound
    private SoundPlayer soundPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//引数：アプリの状態情報
        super.onCreate(savedInstanceState);//親クラスのメソッドを呼び出しておく。
        setContentView(R.layout.activity_main);//画面に表示すべきビューを設定する。


        soundPlayer = new SoundPlayer(this);



        //findViewByIdでactivity_mainで設定したidからviewを探す。
        myChar = findViewById(R.id.mychar);
        enemy = findViewById(R.id.enemy_mob3);
        enemyth = findViewById(R.id.enemy_mob31);
        enemyth2 = findViewById(R.id.enemy_mob32);
        e_bullet = findViewById(R.id.attack_effect_enemy);
        mc_bullet = findViewById(R.id.attack_effect_mychar);
        startLabel = findViewById(R.id.startLabel);
        scoreLabel = findViewById(R.id.scoreLabel);

        //フォントの設定
        Typeface customFont = Typeface.createFromAsset(getAssets(), "PixelMplus10-Regular.ttf");
        scoreLabel.setTypeface(customFont);


        //画面の横幅の取得 → FrameDataクラスへ
        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay(); //画面のサイズの取得
        Point size = new Point();
        display.getSize(size);
        fData.setScreenWidth(size.x);

        //スピードの設定
        myCharSpeed = Math.round(fData.getScreenWidth() / 60f);
        mc_bulletSpeed = Math.round(fData.getScreenWidth() / 20f);

        //初期位置を設定　xmlファイルに分けれるかも。
        enemy.setX(450.0f);
        enemy.setY(250.0f);

        enemyth2.setX(250.0f);
        enemyth2.setY(450.0f);

        e_bullet.setX(497.0f); //enemyX + 47
        e_bullet.setY(400.0f); //enemyY + 150

        myChar.setX(450.0f);
        myChar.setY(1500.0f);
        mc_bullet.setX(506.0f); //myCharX + 56
        mc_bullet.setY(1500.0f);
        mc_bullet.setX(-70.0f);
        mc_bullet.setY(-70.0f);

        //弾を非表示
        //mc_bullet.setVisibility(View.GONE);
        //e_bullet.setVisibility(View.GONE);

        scoreLabel.setText(getString(R.string.score, 0));

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!start_flg){
            start_flg = true;

            //レイアウトの高さを取得　→　FrameDataクラスへ
            FrameLayout frame = findViewById(R.id.frame);
            fData.setFrameHeight(frame.getHeight());

            mcData.setData(myChar);
            myChar1.setData(mcData, fData);

            //myChar座標の取得
            myCharX = myChar.getX();
            myCharY = myChar.getY();
            //myCharサイズの取得
            myCharWidth = myChar.getWidth();
            myCharHeight = myChar.getHeight();

            //敵
            eData1.setData(enemy);
            enemy1.setData(eData1, fData);

            bData1.setData(e_bullet);
            e1Bullet.setData(bData1, fData, eData1);

            eData2.setData(enemyth);
            enemy2.setData(eData2,fData);

            eData3.setData(enemyth2);
            enemy3.setData(eData3,fData);



            //弾　座標
            mc_bulletX = mc_bullet.getX();
            mc_bulletY = mc_bullet.getY();

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

        myChar1.move(action_flg);
        enemy1.move();
        e1Bullet.move();
        enemy2.move();
        enemy3.move();


        /*
        //MyChar
        if (action_flg) {
            myCharX -= myCharSpeed;
        } else {
            myCharX += myCharSpeed;
        }
        //frameの中にいるかの判定
        if (myCharX < 0) myCharX = 0;

        if (myCharX > fData.getScreenWidth() - myCharWidth) myCharX = fData.getScreenWidth() - myCharWidth;

        myChar.setX(myCharX);

         */


        //自キャラの弾
        if(mc_bulletY < 0){
            mc_bulletY = myChar.getY();
            mc_bulletX = myCharX + mcBCorrection;

            mc_bullet.setX(mc_bulletX);
        }else{
            mc_bulletY -= mc_bulletSpeed;
        }
        mc_bullet.setY(mc_bulletY);

        //スコアの更新
        scoreLabel.setText(getString(R.string.score, score));
    }

        public void hitCheck(){
        //敵　弾
        float eBulletCenterX = e_bullet.getX() + e_bullet.getWidth() / 2.0f;
        float eBulletCenterY = e_bullet.getY() + e_bullet.getHeight() / 2.0f;



        if(hitStatus(eBulletCenterX, eBulletCenterY)){ //trueならヒット
            score += 10;
            // Game Over!
            if (timer != null) {
                timer.cancel();
                timer = null;
                //soundPlayer.playOverSound();
            }

            // 結果画面へ
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
        }
    }

    public boolean hitStatus(float ebCenterX, float ebCenterY){ //trueならヒット
        return (myCharY <= ebCenterY && ebCenterY <= myCharHeight + myCharY &&
                myCharX <= ebCenterX && ebCenterX <= myCharX + myCharWidth);
    }

    //バックボタン無効化
    @Override
    public void onBackPressed() { }
}

