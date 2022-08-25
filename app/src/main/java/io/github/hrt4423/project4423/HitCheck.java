package io.github.hrt4423.project4423;

import android.content.Intent;

public class HitCheck {
    //ヒットフラグ
    public static boolean hit_flg;

    public static boolean hitCheck(ActivityData charData, ActivityData bulletData){
        //ヒットしたかの判定
        int cHeight = charData.getImgHeight();
        int cWidth = charData.getImgWidth();
        float cX = charData.getImgX();
        float cY = charData.getImgY();
        float bulletCenterX = bulletData.getImgCenterX();
        float bulletCenterY = bulletData.getImgCenterY();

        //HitCheck.hit_flg = false;

        if(bulletCenterY >= cY && bulletCenterY <= cY + cHeight &&
                bulletCenterX >= cX && bulletCenterX <= cX + cWidth){
            hit_flg = true;
        }else{
            hit_flg = false;
        }
        return hit_flg;
    }

    public static boolean getHitFlg(){
        return hit_flg;
    }
}
