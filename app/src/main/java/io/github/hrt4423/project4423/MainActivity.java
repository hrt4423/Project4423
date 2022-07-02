package io.github.hrt4423.project4423;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //ImageViewクラスの変数
    private ImageView myChar;
    private ImageView enemy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//引数：アプリの状態情報
        super.onCreate(savedInstanceState);//親クラスのメソッドを呼び出しておく。
        setContentView(R.layout.activity_main);//画面に表示すべきビューを設定する。


        //findViewByIdでactivity_mainで設定したidからviewを探す。
        myChar = findViewById(R.id.mychar);
        enemy = findViewById(R.id.enemy_mob3);

        //setX setY メソッドで座標を設定
        myChar.setX(175);
        myChar.setY(563);
    }

    public boolean onTouchEvent(MotionEvent event) {

        return true;
    }



}

