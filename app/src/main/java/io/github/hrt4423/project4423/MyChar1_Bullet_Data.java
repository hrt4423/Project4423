package io.github.hrt4423.project4423;

import android.widget.ImageView;

public class MyChar1_Bullet_Data extends ActivityData{
    /*フィールド変数
    ImageView image;
    int imgHeight, imgWidth;
    float imgX, imgY;
     */

    @Override
    public void setData(ImageView iv){
        image = iv;
        imgX = image.getX();
        imgY = image.getY();
        imgHeight = image.getHeight();
        imgWidth = image.getWidth();
    }

    @Override
    public float getImgX(){
        return imgX;
    }

    @Override
    public float getImgY() {
        return imgY;
    }

    @Override
    public void setImgX(float imgX){
        this.image.setX(imgX);
        this.imgX = imgX;
    }

    @Override
    public void setImgY(float imgY){
        this.image.setY(imgY);
        this.imgY = imgY;
    }

    @Override
    public int getImgHeight(){
        return imgHeight;
    }

    @Override
    public int getImgWidth(){
        return imgWidth;
    }

    @Override
    protected float getImgCenterX() {
        return imgX + imgWidth / 2.0f;
    }

    @Override
    protected float getImgCenterY() {
        return imgY + imgHeight / 2.0f;
    }
}
