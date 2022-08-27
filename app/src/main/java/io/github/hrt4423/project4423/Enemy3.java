package io.github.hrt4423.project4423;
//敵側でギザギザ動き
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
        if(motionFlgX){
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

    }
}
