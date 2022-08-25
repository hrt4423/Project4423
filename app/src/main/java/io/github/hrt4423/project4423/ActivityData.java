package io.github.hrt4423.project4423;

import android.widget.ImageView;

abstract class ActivityData {
    protected ImageView image;
    protected int imgHeight, imgWidth;
    protected float imgX, imgY;
    protected float imgCenterX, imgCenterY;

     abstract protected void setData(ImageView iv);

     abstract protected float getImgX();
     abstract protected float getImgY();
     abstract protected void setImgX(float imgX);
     abstract protected void setImgY(float imgY);

     abstract protected int getImgHeight();
     abstract protected int getImgWidth();
     abstract protected float getImgCenterX();
     abstract protected float getImgCenterY();
}
