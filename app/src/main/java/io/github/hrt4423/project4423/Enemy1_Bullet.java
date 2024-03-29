package io.github.hrt4423.project4423;

public class Enemy1_Bullet extends Bullet{
    @Override
    public void setData(ActivityData bulletData, FrameData frameData, ActivityData charData){
        bD = bulletData;
        fD = frameData;
        cD = charData;
        speed = Math.round(fD.getScreenWidth()/30f);
    }

    @Override
    protected void move() {
        //画面外に出た場合、敵キャラの位置に戻す。
        // 座標を指定するだけでは見た目がズレるので補正している。（中心座標を使えばシンプルに書けそう。）
        if(bD.getImgY() > fD.getFrameHeight()){
            bD.setImgX(cD.getImgX() + eBCorrectionX);
            bD.setImgY(cD.getImgY() + eBCorrectionY);
        }else{//弾を下に動かす
            bD.setImgY(bD.getImgY() + speed - 10);
        }
    }
}
