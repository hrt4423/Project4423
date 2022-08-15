package io.github.hrt4423.project4423;

abstract class MyChar {
    protected MyCharData mcD;
    protected FrameData fD;
    protected int speed;
    protected boolean action_flg;

    abstract protected void setData(MyCharData myCharData, FrameData frameData);
    abstract protected void move(boolean action_flg);
}
