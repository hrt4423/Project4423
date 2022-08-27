package io.github.hrt4423.project4423;

public class Enemy1 extends Enemy{

    @Override
    public void setData(ActivityData enemyData, FrameData frameData){
        eD = enemyData;
        fD = frameData;
        speed = Math.round(fD.getScreenWidth()/60f);
    }

    @Override
    public void move(){

        //動く向き
        if(motionFlgX){
            //右
            eD.setImgX(eD.getImgX() + speed);
        }else{
            //左
            eD.setImgX(eD.getImgX() - speed);
        }

        //画面外の時の処理
        if (eD.getImgX() < 0){
            eD.setImgX(eD.getImgX());
            motionFlgX = true;
        }
        //画面外のときの処理
        if (eD.getImgX() > fD.getScreenWidth() -eD.getImgWidth()) {
            eD.setImgX(fD.getScreenWidth() - eD.imgWidth);
            motionFlgX = false;
        }
    }
}

