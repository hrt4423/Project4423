package io.github.hrt4423.project4423;

import android.widget.ImageView;

abstract class Enemy {
    private int enemySpeed;
    private static boolean motionFlg = true;//true:右, false:左



    public void setData(){
        this.enemy = enemy;
        this.enemyX = enemy.getX();
        this.enemySize = enemy.getWidth();
    }

    /*
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

        //値の更新
        enemy.setX(enemyX);



    }

     */
}


