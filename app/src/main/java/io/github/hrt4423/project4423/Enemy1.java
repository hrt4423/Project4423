package io.github.hrt4423.project4423;

import android.widget.ImageView;

public class Enemy1 extends Enemy{
    @Override
    public void setData(EnemyData enemyData, FrameData frameData){
        eD = enemyData;
        fD = frameData;
        enemySpeed = Math.round(fD.getScreenWidth()/60f);
    }

    @Override
    public void enemyMove(){
        //動く向き
        if(motionFlg){
            //右
            eD.setImgX(eD.getImgX() + enemySpeed);
        }else{
            //左
            eD.setImgX(eD.getImgX() - enemySpeed);
        }

        //画面外の時の処理
        if (eD.getImgX() < 0){
            eD.setImgX(1);
            motionFlg = true;
        }
        //画面外のときの処理
        if (eD.getImgX() > fD.getScreenWidth() - eD.imgWidth) {
            eD.setImgX(fD.getScreenWidth() - eD.imgWidth);
            motionFlg = false;
        }
    }
}


