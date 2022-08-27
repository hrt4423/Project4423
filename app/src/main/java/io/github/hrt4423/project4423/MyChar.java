package io.github.hrt4423.project4423;

abstract class MyChar {
    protected MyChar1_Data mcD;
    protected FrameData fD;
    protected int speed;
    protected boolean action_flg;

    abstract protected void setData(MyChar1_Data myCharData, FrameData frameData);
    abstract protected void move(boolean action_flg);
}
