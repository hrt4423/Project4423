package io.github.hrt4423.project4423;

public class FrameData {
    private int frameHeight;
    private int screenWidth;

    public void setScreenWidth(int screenWidth){
        this.screenWidth = screenWidth;
    }

    public void setFrameHeight(int frameHeight){
        this.frameHeight = frameHeight;
    }

    public int getScreenWidth() { return screenWidth; }

    public int getFrameHeight(){
        return frameHeight;
    }

}
