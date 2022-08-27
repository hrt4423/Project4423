package io.github.hrt4423.project4423;

abstract class Bullet {
    protected ActivityData bD;
    protected FrameData fD;
    protected ActivityData eD;
    //protected MyCharData;

    protected int speed;

    protected int mcBCorrection = 56;
    protected int eBCorrectionX = 47;
    protected int eBCorrectionY = 150;

    abstract protected void setData(ActivityData bulletData1Data, FrameData frameData, ActivityData enemyData);

    abstract protected void move();
}
