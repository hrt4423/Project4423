package io.github.hrt4423.project4423;

import android.widget.ImageView;

public class EnemyData extends ActivityData{
    //enemySize = enemy.getWidth();

    /*フィールド変数
    ImageView image;
    int imgHeight, imgWidth;
    float imgX, imgY;
     */
    private int enemySpeed;

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
    public int getImgHeight(){
        return imgHeight;
    }

    @Override
    public int getImgWidth(){
        return imgWidth;
    }
}
