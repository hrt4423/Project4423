package io.github.hrt4423.project4423;

import android.content.Intent;

public class HitCheck {
    //ヒットフラグ
    public static boolean hit_flg;
    public static boolean score_flg;

    public static void hitStatus_MyChar(ActivityData charData, ActivityData bulletData){
        //ヒットしたかの判定
        int cHeight = charData.getImgHeight();
        int cWidth = charData.getImgWidth();
        float cX = charData.getImgX();
        float cY = charData.getImgY();
        float bulletCenterX = bulletData.getImgCenterX();
        float bulletCenterY = bulletData.getImgCenterY();

        if(bulletCenterY >= cY && bulletCenterY <= cY + cHeight &&
                bulletCenterX >= cX && bulletCenterX <= cX + cWidth){
            hit_flg = true;
        }else{
            hit_flg = false;
        }
    }

    public static boolean hitStatus_Enemy(ActivityData charData, ActivityData bulletData){
        score_flg = false;
        //ヒットしたかの判定
        int cHeight = charData.getImgHeight();
        int cWidth = charData.getImgWidth();
        float cX = charData.getImgX();
        float cY = charData.getImgY();
        float bulletCenterX = bulletData.getImgCenterX();
        float bulletCenterY = bulletData.getImgCenterY();

        if(bulletCenterY >= cY && bulletCenterY <= cY + cHeight &&
                bulletCenterX >= cX && bulletCenterX <= cX + cWidth){
            score_flg = true;
        }
        return score_flg;
    }

    public static boolean getHitFlg(){
        return hit_flg;
    }
}
