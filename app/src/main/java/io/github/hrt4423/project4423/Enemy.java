package io.github.hrt4423.project4423;

import android.widget.ImageView;

abstract class Enemy {

    protected ActivityData eD;
    protected FrameData fD;
    protected int speed;
    protected boolean motionFlgX = false;//true:右, false:左
    protected boolean motionFlgY = true;//true:下, false:上

    abstract protected void setData(ActivityData enemyData, FrameData frameData);

    abstract protected void move();
}


