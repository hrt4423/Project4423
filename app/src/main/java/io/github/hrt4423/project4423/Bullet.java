package io.github.hrt4423.project4423;

abstract class Bullet {
    protected BulletData bD;
    protected FrameData fD;
    protected EnemyData eD;
    //protected MyCharData;

    protected int speed;

    protected int mcBCorrection = 56;
    protected int eBCorrectionX = 47;
    protected int eBCorrectionY = 150;

    abstract protected void setData(BulletData bulletDataData, FrameData frameData, EnemyData enemyData);

    abstract protected void move();
}
