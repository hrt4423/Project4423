package io.github.hrt4423.project4423;

import android.media.Image;
import android.widget.ImageView;

public class Bullet {
    private int fHeight, sWidth;

    private ImageView bullet;
    private ImageView enemy;
    private  int bulletSpeed;
    private float bulletX, bulletY;
    private int bHeight, bWidth;


    private int mcBCorrection = 56;
    private int eBCorrectionX = 47;
    private int eBCorrectionY = 150;

    Bullet(int fHeight, int sWidth){
        this.fHeight = fHeight;
        this.sWidth = sWidth;
        this.bulletSpeed = Math.round(sWidth/60f);
    }

    public void setBulletInfo(ImageView bullet, ImageView enemy){
        this.bullet = bullet;
        this.enemy = enemy;

        this.bulletX = bullet.getX();
        this.bulletY = bullet.getY();

        this.bHeight = bullet.getHeight();
        this.bWidth = bullet.getWidth();
    }

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
}
