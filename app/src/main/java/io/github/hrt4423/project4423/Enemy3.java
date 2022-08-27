package io.github.hrt4423.project4423;

public class Enemy3 extends Enemy{
    @Override
    public void setData(ActivityData enemyData, FrameData frameData){
        eD = enemyData;
        fD = frameData;
        speed = Math.round(fD.getScreenWidth()/60f);
    }

    @Override
    public void move(){
        //動く向き
        /*if(motionFlgX){
            //右
            cD.setImgX(cD.getImgX() + speed);
        }else{
            //左
            cD.setImgX(cD.getImgX() - speed);
        }

         */

        if(motionFlgY){
            //上
            eD.setImgY(eD.getImgY() + speed);
        }else{
            //下
            eD.setImgY(eD.getImgY() - speed);
        }

        //画面外の時の処理
        /*
        if (cD.getImgX() < 0){
            cD.setImgX(1);
            motionFlgX = true;
        }
        //画面外のときの処理
        if (cD.getImgX() > fD.getScreenWidth() - cD.imgWidth) {
            cD.setImgX(fD.getScreenWidth() - cD.imgWidth);
            motionFlgX = false;
        }
        */
        if(eD.getImgY() < 0){
            eD.setImgY(1);
            motionFlgY = true;
        }

        if(eD.getImgY() > fD.getFrameHeight() - eD.imgHeight){
            eD.setImgY(fD.getFrameHeight() - eD.imgHeight);
            motionFlgY = false;
        }
    }
}
