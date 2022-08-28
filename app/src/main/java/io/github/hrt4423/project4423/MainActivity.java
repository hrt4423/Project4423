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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //各インスタンス
    //フレームデータ
    public FrameData fData = new FrameData();

    //自キャラ
    public MyChar1 myChar1 = new MyChar1();
    public MyChar1_Data mcData = new MyChar1_Data();
    //自キャラ弾
    public Bullet mcBullet = new MyChar1_Bullet();
    public ActivityData mcBData = new MyChar1_Bullet_Data();

    //敵１
    public Enemy enemy1 = new Enemy1();
    public ActivityData eData1 = new Enemy1_Data();
    //弾１
    public Bullet e1Bullet = new Enemy1_Bullet();
    public ActivityData b1Data = new Enemy1_Bullet_Data();

    //敵２
    public Enemy enemy2 = new Enemy2();
    public ActivityData eData2 = new Enemy2_Data();
    //弾２
    public Bullet e2Bullet = new Enemy2_Bullet();
    public ActivityData b2Data = new Enemy2_Bullet_Data();

    //敵３
    public Enemy enemy3 = new Enemy3();
    public ActivityData eData3 = new Enemy3_Data();
    //弾3
    public Bullet e3Bullet = new Enemy3_Bullet();
    public ActivityData b3Data = new Enemy3_Bullet_Data();


    //変数
    //ImageViewクラスの変数
    private ImageView myChar;
    private ImageView mc_bullet;

    private ImageView enemy1_1;
    private ImageView e1_1_bullet;

    private ImageView enemy2_1;
    private ImageView e2_1_bullet;

    private ImageView enemy3_1;
    private ImageView e3_1_bullet;

    private TextView startLabel;
    private TextView scoreLabel;
    private boolean start_flg;

    private int score = 0;

    //TODO 別ファイルに分離　弾　自キャラ
    private int mc_bulletSpeed;
    private float mc_bulletX, mc_bulletY;
    private int mc_bulletSize;


    //自キャラと弾のずれ補正値
    private int mcBCorrection = 56;
    private int eBCorrectionX = 47;
    private int eBCorrectionY = 150;

    //-----------------------------------------------
    private  boolean action_flg = false;

    private Timer timer = new Timer();
    private Handler handler = new Handler();

    // Sound
    private SoundPlayer soundPlayer;
    //------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {//引数：アプリの状態情報
        super.onCreate(savedInstanceState);//親クラスのメソッドを呼び出しておく。
        setContentView(R.layout.activity_main);//画面に表示すべきビューを設定する。

        soundPlayer = new SoundPlayer(this);

        //findViewByIdでactivity_mainで設定したidからviewを探す。
        myChar = findViewById(R.id.mychar);
        mc_bullet = findViewById(R.id.attack_effect_mychar);

        enemy1_1 = findViewById(R.id.enemy1_1);
        enemy2_1 = findViewById(R.id.enemy2_1);
        enemy3_1 = findViewById(R.id.enemy3_1);

        e1_1_bullet = findViewById(R.id.bullet_1);
        e2_1_bullet = findViewById(R.id.bullet_2);
        e3_1_bullet = findViewById(R.id.bullet_3);


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

        //TODO 自キャラの弾の処理を別ファイルに分離 スピードの設定
        mc_bulletSpeed = Math.round(fData.getScreenWidth() / 20f);

        //初期位置を設定　xmlファイルに分けれるかも。
        enemy1_1.setX(450.0f);
        enemy1_1.setY(-300.0f);

        enemy2_1.setX(750.0f);
        enemy2_1.setY(-300.0f);

        enemy3_1.setX(150.0f);
        enemy3_1.setY(-300.0f);

        e1_1_bullet.setX(-100.0f);
        e2_1_bullet.setX(-100.0f);
        e3_1_bullet.setX(-100.0f);

        myChar.setX(450.0f);
        myChar.setY(1500.0f);
        mc_bullet.setX(-100.0f);

        //弾を非表示
        e1_1_bullet.setVisibility(View.GONE);
        e2_1_bullet.setVisibility(View.GONE);
        e3_1_bullet.setVisibility(View.GONE);

        scoreLabel.setText(getString(R.string.score, 0));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!start_flg){
            start_flg = true;

            //レイアウトの高さを取得　→　FrameDataクラスへ
            FrameLayout frame = findViewById(R.id.frame);
            fData.setFrameHeight(frame.getHeight());

            //敵キャラ
            setCharData();

            //弾
            setBulletData();

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

        move();

        //弾を表示
        e1_1_bullet.setVisibility(View.VISIBLE);
        e2_1_bullet.setVisibility(View.VISIBLE);
        e3_1_bullet.setVisibility(View.VISIBLE);

        //スコアの更新
        scoreLabel.setText(getString(R.string.score, score));
    }

    public void setCharData(){
        eData1.setData(enemy1_1);
        enemy1.setData(eData1, fData);

        eData2.setData(enemy2_1);
        enemy2.setData(eData2,fData);

        eData3.setData(enemy3_1);
        enemy3.setData(eData3,fData);

        mcData.setData(myChar);
        myChar1.setData(mcData, fData);
    }

    public void setBulletData(){
        b1Data.setData(e1_1_bullet);
        e1Bullet.setData(b1Data, fData, eData1);

        b2Data.setData(e2_1_bullet);
        e2Bullet.setData(b2Data, fData, eData2);

        b3Data.setData(e3_1_bullet);
        e3Bullet.setData(b3Data, fData, eData3);

        mcBData.setData(mc_bullet);
        mcBullet.setData(mcBData, fData, mcData);
    }

    public void move(){
        myChar1.move(action_flg);
        mcBullet.move();

        enemy1.move();
        e1Bullet.move();

        enemy2.move();
        e2Bullet.move();

        enemy3.move();
        e3Bullet.move();
    }

    public void hitCheck(){
        if(HitCheck.hitStatus_Enemy(eData1, mcBData)){
            score += 10;
            mcBData.setImgX(mcData.getImgX());
            mcBData.setImgY(mcData.getImgY());
            enemy1.setEnemyStatus("E");
        }
        if(HitCheck.hitStatus_Enemy(eData2, mcBData)){
            score += 20;
            mcBData.setImgX(mcData.getImgX());
            mcBData.setImgY(mcData.getImgY());
            enemy2.setEnemyStatus("E");
        }
        if(HitCheck.hitStatus_Enemy(eData3, mcBData)){
            score += 20;
            mcBData.setImgX(mcData.getImgX());
            mcBData.setImgY(mcData.getImgY());
            enemy3.setEnemyStatus("E");
        }

        HitCheck.hitStatus_MyChar(mcData, b1Data);
        if(HitCheck.getHitFlg()){ //trueならヒット
            // Game Over!
            if (timer != null) {
                timer.cancel();
                timer = null;
                soundPlayer.playOverSound();
            }

            // 結果画面へ
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
        }

        HitCheck.hitStatus_MyChar(mcData, b2Data);
        if(HitCheck.getHitFlg()){ //trueならヒット
            // Game Over!
            if (timer != null) {
                timer.cancel();
                timer = null;
                soundPlayer.playOverSound();
            }

            // 結果画面へ
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
        }

        HitCheck.hitStatus_MyChar(mcData, b3Data);
        if(HitCheck.getHitFlg()){ //trueならヒット
            // Game Over!
            if (timer != null) {
                timer.cancel();
                timer = null;
                soundPlayer.playOverSound();
            }

            // 結果画面へ
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
        }
    }

    //バックボタン無効化---------------------------------------------------------------------------------
    @Override
    public void onBackPressed() { }
    //-----------------------------------------------------------------------------------------------
}

