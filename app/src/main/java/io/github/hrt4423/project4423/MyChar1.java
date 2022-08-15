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

        //MyChar
        if (action_flg) {
            mcD.setImgX(mcD.getImgX() - speed);
        } else {
            mcD.setImgX(mcD.getImgX() + speed);
        }
        //frameの中にいるかの判定
        if (mcD.getImgX() < 0) mcD.setImgX(0);

        if (mcD.getImgX() > fD.getScreenWidth() - mcD.getImgWidth()) {
            mcD.setImgX(fD.getScreenWidth() - mcD.getImgWidth());
        }
    }


}
