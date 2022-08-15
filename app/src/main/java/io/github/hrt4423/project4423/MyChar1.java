package io.github.hrt4423.project4423;

public class MyChar1 extends MyChar{
    @Override
    protected void setData(MyCharData myCharData, FrameData frameData) {
        mcD = myCharData;
        fD = frameData;

        speed = Math.round(fD.getScreenWidth() / 60f);
    }

    @Override
    protected void move(boolean action_flg) {
        this.action_flg = action_flg;

    }
}
