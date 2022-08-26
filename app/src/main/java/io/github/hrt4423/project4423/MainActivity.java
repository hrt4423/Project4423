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
    public MyCharData mcData = new MyCharData();

    //敵１
    public Enemy enemy1 = new Enemy1();
    public ActivityData eData1 = new Enemy1Data();

    //敵２
    public Enemy enemy2 = new Enemy2();
    public ActivityData eData2 = new Enemy2Data();

    //敵３
    public Enemy enemy3 = new Enemy4();
    public ActivityData eData3 = new Enemy3Data();

    //弾１
    public Bullet1Data bData1 = new Bullet1Data();
    public Enemy1Bullet e1Bullet = new Enemy1Bullet();

    //変数
    //ImageViewクラスの変数
    private ImageView myChar;
    private ImageView mc_bullet;

    private ImageView enemy1_1;
    private ImageView e1_bullet;

    private ImageView enemy2_1;


    private ImageView enemy3_1;


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

        enemy1_1 = findViewById(R.id.enemy1_1);
        enemy2_1 = findViewById(R.id.enemy2_1);
        enemy3_1 = findViewById(R.id.enemy3_1);

        e1_bullet = findViewById(R.id.attack_effect_enemy);
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

        //TODO 自キャラの弾の処理を別ファイルに分離 スピードの設定
        mc_bulletSpeed = Math.round(fData.getScreenWidth() / 20f);

        //初期位置を設定　xmlファイルに分けれるかも。
        enemy1_1.setX(450.0f);
        enemy1_1.setY(250.0f);

        enemy2_1.setX(250.0f);
        enemy2_1.setY(450.0f);

        e1_bullet.setX(497.0f); //enemyX + 47
        e1_bullet.setY(400.0f); //enemyY + 150

        myChar.setX(450.0f);
        myChar.setY(1500.0f);
        mc_bullet.setX(506.0f); //myCharX + 56
        mc_bullet.setY(1500.0f);
        mc_bullet.setX(-70.0f);
        mc_bullet.setY(-70.0f);

        //弾を非表示
        //mc_bullet.setVisibility(View.GONE);
        //e1_bullet.setVisibility(View.GONE);

        scoreLabel.setText(getString(R.string.score, 0));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!start_flg){
            start_flg = true;

            //レイアウトの高さを取得　→　FrameDataクラスへ
            FrameLayout frame = findViewById(R.id.frame);
            fData.setFrameHeight(frame.getHeight());

            //各キャラクターと弾
            //自キャラ
            mcData.setData(myChar);
            myChar1.setData(mcData, fData);

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
        //ヒットチェック
        HitCheck.hitCheck(mcData, bData1);

        myChar1.move(action_flg);

        enemy1.move();
        e1Bullet.move();
        enemy2.move();
        enemy3.move();

        //自キャラの弾
        if(mc_bulletY < 0){
            mc_bulletY = mcData.getImgY();
            //mc_bulletX = myCharX + mcBCorrection;
            mc_bulletX = mcData.getImgX() + mcBCorrection;

            mc_bullet.setX(mc_bulletX);
        }else{
            mc_bulletY -= mc_bulletSpeed;
        }
        mc_bullet.setY(mc_bulletY);

        //ゲームの継続判定------------------------------------------------------------------
        if(HitCheck.getHitFlg()){ //trueならヒット
            score += 10;
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
        //-----------------------------------------------------------------------------

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
    }

    public void setBulletData(){
        bData1.setData(e1_bullet);
        e1Bullet.setData(bData1, fData, eData1);
    }

    //バックボタン無効化---------------------------------------------------------------------------------
    @Override
    public void onBackPressed() { }
    //-----------------------------------------------------------------------------------------------
}

