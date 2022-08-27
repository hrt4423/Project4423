package io.github.hrt4423.project4423;

public class MyChar1_Bullet extends Bullet{
    @Override
    public void setData(ActivityData bulletData, FrameData frameData, ActivityData charData){
        bD = bulletData;
        fD = frameData;
        cD = charData;
        speed = Math.round(fD.getScreenWidth()/30f);
    }

    @Override
    protected void move() {
        float x = bD.getImgX();
        float y = bD.getImgY();
        //画面外に出た場合、敵キャラの位置に戻す。
        // 座標を指定するだけでは見た目がズレるので補正している。（中心座標を使えばシンプルに書けそう。）
        if(y < 0){
            bD.setImgY(cD.getImgY());
            bD.setImgX(cD.getImgX() + mcBCorrection);
        }else{
            bD.setImgY(y - speed);
        }
    }
}
