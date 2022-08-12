package io.github.hrt4423.project4423;

import android.widget.ImageView;

abstract class ActivityData {
    private ImageView image;
    private int imgWidth, imgHeight;
    private float imgX, imgY;

    abstract protected void setData();
    abstract protected void getData();


}
