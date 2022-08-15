package io.github.hrt4423.project4423;

public class Enemy1Bullet extends Bullet{
    @Override
    public void setData(BulletData bulletDataData, FrameData frameData, ActivityData enemyData){
        bD = bulletDataData;
        fD = frameData;
        eD = enemyData;
        speed = Math.round(fD.getScreenWidth()/60f);
    }

    @Override
    protected void move() {
        //画面外に出た場合、敵キャラの位置に戻す。
        // 座標を指定するだけでは見た目がズレるので補正している。（中心座標を使えばシンプルに書けそう。）
        if(bD.getImgY() > fD.getFrameHeight()){
            bD.setImgX(eD.getImgX() + eBCorrectionX);
            bD.setImgY(eD.getImgY() + eBCorrectionY);
        }else{//弾を下に動かす
            bD.setImgY(bD.getImgY() + speed);
        }
    }
}
