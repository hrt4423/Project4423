package io.github.hrt4423.project4423;

import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy {
    private int sWidth;
    private int fHeight;
    private static boolean motionFlg = true;//true:右, false:左
    private ImageView enemy;
    private int enemySpeed;
    private float enemyX, enemyY;
    private int enemySize;
    //staticでないと機能しない。
    private static boolean motionFlg = true;//true:右, false:左

    Enemy(int sWidth){
        this.sWidth = sWidth;

        this.enemySpeed = Math.round(sWidth/ 60f);





    public void setEnemyInfo(ImageView enemy){
        this.enemy = enemy;
        this.enemyX = enemy.getX();
        this.enemyY = enemy.getY();
        this.enemySize = enemy.getWidth();
    }

    public void eMotion(){


        //動く向き

        if(motionFlg){
            //右
            enemyX += enemySpeed;
        }else{
            //左
            enemyX -= enemySpeed;
        }


        //画面外の時の処理
        if (enemyX < 0){
            enemyX = 1;
            motionFlg = true;
        }
        //画面外のときの処理
        if (enemyX > sWidth - enemySize) {
            enemyX = sWidth - enemySize;
            motionFlg = false;
        }



        //画面外に出たときの処理
        if (enemyX < -enemySize) {
            enemyX = sWidth  + 20;

        }else if(enemyX > sWidth +20){
            enemyX = -20;



        //画面外の時の処理
        if (enemyX < 0){
            enemyX = 1;
            motionFlg = true;
        }
        //画面外のときの処理
        if (enemyX > sWidth - enemySize) {
            enemyX = sWidth - enemySize;
            motionFlg = false;

        }



        //値の更新
        enemy.setX(enemyX);

        enemy.setY(enemyY);


    }


}






