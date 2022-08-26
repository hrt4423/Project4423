package io.github.hrt4423.project4423;

import android.widget.ImageView;

public class Enemy1_Data extends ActivityData{
    /*フィールド変数
    ImageView image;
    int imgHeight, imgWidth;
    float imgX, imgY;
     */

    @Override
    protected void setData(ImageView iv){
        image = iv;
        imgX = image.getX();
        imgY = image.getY();
        imgHeight = image.getHeight();
        imgWidth = image.getWidth();
    }

    @Override
    protected float getImgX(){
        return imgX;
    }

    @Override
    protected float getImgY() {
        return imgY;
    }

    @Override
    protected void setImgX(float imgX){
        this.image.setX(imgX);
        this.imgX = imgX;
    }

    @Override
    protected void setImgY(float imgY){
        this.image.setY(imgY);
        this.imgY = imgY;
    }

    @Override
    protected int getImgHeight(){
        return imgHeight;
    }

    @Override
    protected int getImgWidth(){
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
