package io.github.hrt4423.project4423;

import android.widget.ImageView;

abstract class ActivityData {
    protected ImageView image;
    protected int imgHeight, imgWidth;
    protected float imgX, imgY;

     abstract protected void setData(ImageView iv);
     abstract protected float getImgX();
     abstract protected float getImgY();
     abstract protected int getImgHeight();
     abstract protected int getImgWidth();


}
