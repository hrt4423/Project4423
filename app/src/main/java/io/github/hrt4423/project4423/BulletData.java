package io.github.hrt4423.project4423;

import android.widget.ImageView;

public class BulletData extends ActivityData{
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
}
