package io.github.hrt4423.project4423;

import android.widget.ImageView;

public class Enemy {
    public static void Enemy1(float enemyX,int enemySize,int screenWidth,int enemySpeed,ImageView enemy){
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
    }

}


