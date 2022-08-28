package io.github.hrt4423.project4423;

abstract class Enemy {

    protected ActivityData eD;
    protected FrameData fD;
    protected int speed;
    protected boolean motionFlgX = false;//true:右, false:左
    protected boolean motionFlgY = true;//true:下, false:上
    protected String enemyStatus = "S";//登場：A, 退場：E, 戦闘：F, 待機：S

    abstract protected void setData(ActivityData enemyData, FrameData frameData);

    abstract protected void move();

    //abstract protected void Appearance();
}


