package io.github.hrt4423.project4423;

import android.widget.ImageView;

abstract class Enemy {

    protected   EnemyData eD;
    protected   FrameData fD;
    protected int enemySpeed;
    protected static boolean motionFlg = true;//true:右, false:左

    abstract protected void setData(EnemyData enemyData, FrameData frameData);

    abstract protected void enemyMove();
}


