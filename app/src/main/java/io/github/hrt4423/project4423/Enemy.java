package io.github.hrt4423.project4423;

import android.widget.ImageView;

public class Enemy {
    private int sWidth;

    private ImageView enemy;
    private int enemySpeed;
    private float enemyX, enemyY;
    private int enemySize;

    Enemy(int sWidth){
        this.sWidth = sWidth;
        this.enemySpeed = Math.round(sWidth/60f);
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


