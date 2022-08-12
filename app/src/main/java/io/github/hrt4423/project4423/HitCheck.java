package io.github.hrt4423.project4423;

import android.media.Image;
import android.widget.ImageView;

public class HitCheck {
    private float bulletCenterX, bulletCenterY;
    private  float imgX, imgY;
    private int imgWidth, imgHeight;


    HitCheck(ImageView character, ImageView bullet){
        bulletCenterX = bullet.getX() + bullet.getWidth() / 2.0f;
        bulletCenterY = bullet.getY() + bullet.getHeight() / 2.0f;
        imgX = character.getX();
        imgY = character.getY();
        imgWidth = character.getWidth();
        imgHeight = character.getHeight();
    }

    public boolean hitStatus(){ //trueならヒット
        return (imgY <= bulletCenterY && bulletCenterY <= imgHeight + imgY &&
                imgX <= bulletCenterX && bulletCenterX <= imgX + imgWidth);
    }


}
