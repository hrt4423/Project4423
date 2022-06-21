package io.github.hrt4423.project4423;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //ImageViewクラスの変数
    private ImageView sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//引数：アプリの状態情報
        super.onCreate(savedInstanceState);//親クラスのメソッドを呼び出しておく。
        setContentView(R.layout.activity_main);//画面に表示すべきビューを設定する。



//findViewByIdでactivity_mainで設定したidからviewを探す。
        sq = findViewById(R.id.sq);

//setX setY メソッドで座標を設定
        sq.setX(100.0f);
        sq.setY(100.0f);
    }
}