package io.github.hrt4423.project4423;

import android.widget.ImageView;

abstract class Enemy {

    protected ActivityData eD;
    protected FrameData fD;
    protected int speed;
    protected static boolean motionFlg = true;//true:右, false:左

    abstract protected void setData(ActivityData enemyData, FrameData frameData);

    abstract protected void move();
}


