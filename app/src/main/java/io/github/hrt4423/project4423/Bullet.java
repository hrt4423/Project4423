package io.github.hrt4423.project4423;

import android.widget.ImageView;

abstract class Enemy1Bullet extends Enemy{

    protected int mcBCorrection = 56;
    protected int eBCorrectionX = 47;
    protected int eBCorrectionY = 150;

    //TODO　BulletDataも取得してくる必要あり。
    @Override
    public void setData(EnemyData enemyData, FrameData frameData){

    }

    @Override
    public void Move(){

    }

/*
    public void bMotion(){

        //敵キャラの弾
        if(bulletY > fHeight){

            bulletY = enemy.getY() + eBCorrectionY;
            bulletX = enemy.getX() + eBCorrectionX;

            bullet.setX(bulletX);
        }else{
            bulletY += bulletSpeed;
        }
        bullet.setY(bulletY);
    }

 */
}
