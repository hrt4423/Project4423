package io.github.hrt4423.project4423;

import android.content.Intent;

public class HitCheck {

    public static boolean hitStatus(ActivityData charData, ActivityData bulletData){
        //ヒットしたかの判定
        int cHeight = charData.getImgHeight();
        int cWidth = charData.getImgWidth();
        float cX = charData.getImgX();
        float cY = charData.getImgY();
        float bulletCenterX = bulletData.getImgCenterX();
        float bulletCenterY = bulletData.getImgCenterY();

        return (bulletCenterY >= cY &&
                bulletCenterY <= cY + cHeight &&
                bulletCenterX >= cX &&
                bulletCenterX <= cX + cWidth);
    }
}
