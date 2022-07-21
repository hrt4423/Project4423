package io.github.hrt4423.project4423;


import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy {
    Timer timer = new Timer();
    private int sWidth;

    private ImageView enemy;
    private int enemySpeed;
    private float enemyX, enemyY;
    private int enemySize;

    /*弾
    private  int e_bulletSpeed;
    private float e_bulletX, e_bulletY;
    private int e_bulletSize;

    private int eBCorrectionX = 47;
    private int eBCorrectionY = 150;
     */

    Enemy(int sWidth){
        this.sWidth = sWidth;
        this.enemySpeed = Math.round(sWidth/ 60f);
    }

    public void setEnemyInfo(ImageView enemy){
        this.enemy = enemy;
        this.enemyX = enemy.getX();
        this.enemyY = enemy.getY();
        this.enemySize = enemy.getWidth();
    }

    public void eMotion(){
        //Enemy 変化量を決めてる
        //enemyX -= enemySpeed;
        //enemyY -= 20;

        if(enemyX > sWidth - 200){
           TimerTask aiueo = new TimerTask() {
               public void run() {
                   enemyX -= enemySpeed;
                   enemy.setX(enemyX);
               }
           };
        }else{
            enemyX += enemySpeed;
        }



        //画面外に出たときの処理
        if (enemyX < -enemySize) {
            enemyX = sWidth  + 20;

        }else if(enemyX > sWidth +20){
            enemyX = -20;

        }

        //値の更新
        enemy.setX(enemyX);
        //enemy.setY(enemyY);
        timer.schedule(aiueo,3000);
    }



}


