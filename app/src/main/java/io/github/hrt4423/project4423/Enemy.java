package io.github.hrt4423.project4423;


import android.provider.ContactsContract;
import android.widget.ImageView;

public class Enemy {
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
        this.enemySize = enemy.getWidth();
    }

    public void eMotion(){
        //Enemy 変化量を決めてる
        enemyX -= enemySpeed;

        //画面外に出たときの処理
        if (enemyX < -enemySize) {
            enemyX = sWidth  + 20;
        }

        //値の更新
        enemy.setX(enemyX);
    }
}


