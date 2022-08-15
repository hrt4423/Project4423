package io.github.hrt4423.project4423;

public class Enemy2 extends Enemy {

    @Override
    public void setData(ActivityData enemyData, FrameData frameData){
        eD = enemyData;
        fD = frameData;
        speed = Math.round(fD.getScreenWidth()/60f);
    }

    @Override
    public void move(){
        //動く向き
        if(motionFlg){
            //右
            eD.setImgX(eD.getImgX() + speed);
        }else{
            //左
            eD.setImgX(eD.getImgX() - speed);
        }

        if(motionFlgY){
            //上
            eD.setImgY(eD.getImgY() + speed);
        }else{
            //下
            eD.setImgY(eD.getImgY() - speed);
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
