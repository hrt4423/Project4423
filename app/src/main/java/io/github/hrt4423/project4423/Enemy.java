package io.github.hrt4423.project4423;

import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy {
    public int sWidth;
    public int fHeight;
    public static boolean motionFlgX = true;//true:右, false:左
    public static boolean motionFlgY = true;//true:右, false:左
    public ImageView enemy;
    public int enemySpeed;
    public float enemyX, enemyY;
    public int enemySize;
    //staticでないと機能しない。

    Enemy(int sWidth, int frameHeight) {
        this.sWidth = sWidth;
        this.fHeight = frameHeight;
        this.enemySpeed = Math.round(sWidth / 60f);
    }





    public void setEnemyInfo(ImageView enemy){
        this.enemy = enemy;
        this.enemyX = enemy.getX();
        this.enemyY = enemy.getY();
        this.enemySize = enemy.getWidth();
    }

    public void eMotion(){

        enemyY += 10;

        //動く向き
        /*
        if(motionFlgX){
            //右
            enemyX += enemySpeed;
        }else{
            //左
            enemyX -= enemySpeed;
        }


        //左右に動く処理
        if (enemyX < 0){
            enemyX = 1;
            motionFlgX = true;
        }
        if (enemyX > sWidth - enemySize) {
            enemyX = sWidth - enemySize;
            motionFlgX = false;
        }

        */

        //画面外に出たときの処理
        if (enemyX < -enemySize) {
            enemyX = sWidth  + 20;

        }else if(enemyX > sWidth +20) {
            enemyX = -20;
        }

        if(enemyY < -enemySize){
            enemyY = fHeight + 20;
        }else if(enemyY > fHeight + 20){
            enemyY = -20;
        }



        //値の更新
        enemy.setX(enemyX);
        enemy.setY(enemyY);


    }


}






