package io.github.hrt4423.project4423;

import android.widget.ImageView;

public class Enemy4 extends Enemy {

    Enemy4(int sWidth, int frameHeight){
        super(sWidth,frameHeight);
    }


    public void setEnemyInfo(ImageView enemy){
        this.enemy = enemy;
        this.enemyX = enemy.getX();
        this.enemyY = enemy.getY();
        this.enemySize = enemy.getWidth();
    }
    public void eMotion(){
        //動く向き
        /*
        if(motionFlgY){
            //右
            enemyY += 5;
        }else{
            //左
            enemyY -= 5;
        }
        */
        if(motionFlgX){
            //右
            enemyX += 10;
        }else{
            //左
            enemyX -= 10;
        }


        //画面外の時の処理
        /*
        if (enemyY < 0){
            enemyY = 1;
            motionFlgY = true;
        }
        //画面外のときの処理
        if (enemyY > fHeight - enemySize) {
            enemyY = fHeight - enemySize;
            motionFlgY = false;
        }
        */
        //画面外の時の処理
        if (enemyX < 0){
            enemyX = 1;
            motionFlgX = true;
        }
        //画面外のときの処理
        if (enemyX > sWidth - enemySize) {
            enemyX = sWidth - enemySize;
            motionFlgX = false;
        }



        //画面外に出たときの処理

        //横
        if (enemyX < -enemySize) {
            enemyX = sWidth  + 20;

        }else if(enemyX > sWidth +20) {
            enemyX = -20;
        }

        //高さ
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



