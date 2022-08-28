package io.github.hrt4423.project4423;

public class Enemy1 extends Enemy{

    @Override
    public void setData(ActivityData enemyData, FrameData frameData){
        eD = enemyData;
        fD = frameData;
        speed = Math.round(fD.getScreenWidth()/60f);
        enemyStatus = "A";
    }

    public void setStatus(String status){
        enemyStatus = status;
    }

    @Override
    public void move(){
        selectMotion();
    }

    public void selectMotion(){
        switch (enemyStatus) {
            case "A":
                Appearance();
                break;
            case "E":
                Exit();
                break;
            case "F":
                Fight();
                break;
            case "S":
                enemyStatus = "A";
        }
    }

    public void Appearance(){
        if(eD.getImgY() < 250) { //画面外の間動かす
            eD.setImgY(eD.getImgY() + speed);
        }else{ //画面内に入ったら戦闘状態に切り替え
            enemyStatus = "F";
        }
    }

    public void Exit(){
        if(eD.getImgY() > -300) { //画面内の間動かす
            eD.setImgY(eD.getImgY() - speed * 2);
        }else{ //画面外に出たら待機状態に切り替え
            enemyStatus = "S";
        }
    }

    public void Fight(){
        //動く向き
        if(motionFlgX){
            //右
            eD.setImgX(eD.getImgX() + speed);
        }else{
            //左
            eD.setImgX(eD.getImgX() - speed);
        }

        //画面外の時の処理
        if (eD.getImgX() < 0){
            eD.setImgX(eD.getImgX());
            motionFlgX = true;
        }
        //画面外のときの処理
        if (eD.getImgX() > fD.getScreenWidth() -eD.getImgWidth()) {
            eD.setImgX(fD.getScreenWidth() - eD.imgWidth);
            motionFlgX = false;
        }
    }
}

