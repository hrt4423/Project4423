package io.github.hrt4423.project4423;

public class Enemy2 extends Enemy{

    @Override
    public void setData(ActivityData enemyData, FrameData frameData){
        eD = enemyData;
        fD = frameData;
        speed = Math.round(fD.getScreenWidth()/60f);
        //enemyStatus = "A";
    }

    @Override
    protected void setEnemyStatus(String status) {
        enemyStatus = status;
    }

    @Override
    public void move(){
        selectMotion();
    }

    @Override
    public void selectMotion(){
        switch (enemyStatus) {
            case "A": //登場のとき
                Appearance();
                break;
            case "E": //退場のとき
                Exit();
                break;
            case "F": //戦闘状態のとき
                Fight();
                break;
            case "S": //待機状態のとき
                enemyStatus = "A";
        }
    }

    @Override
    public void Appearance(){
        if(eD.getImgY() < 250) { //画面外の間動かす
            eD.setImgY(eD.getImgY() + speed);
        }else{ //画面内に入ったら戦闘状態に切り替え
            enemyStatus = "F";
        }
    }

    @Override
    public void Exit(){
        if(eD.getImgY() > -300) { //画面内の間動かす
            eD.setImgY(-350);
        }else{ //画面外に出たら待機状態に切り替え
            enemyStatus = "S";
        }
    }

    @Override
    public void Fight(){
        //動く向き
        if(motionFlgX){
            //右
            eD.setImgX(eD.getImgX() + speed);
        }else{
            //左
            eD.setImgX(eD.getImgX() - speed);
        }

        if(motionFlgY){
            //上
            eD.setImgY(eD.getImgY() + speed);
        }else{
            //下
            eD.setImgY(eD.getImgY() - speed);
        }

        //画面外の時の処理
        if (eD.getImgX() < 0){
            eD.setImgX(1);
            motionFlgX = true;
        }
        //画面外のときの処理
        if (eD.getImgX() > fD.getScreenWidth() - eD.imgWidth) {
            eD.setImgX(fD.getScreenWidth() - eD.imgWidth);
            motionFlgX = false;
        }

        if(eD.getImgY() < 0){
            eD.setImgY(1);
            motionFlgY = true;
        }

        if(eD.getImgY() > fD.getFrameHeight() - eD.imgHeight){
            eD.setImgY(fD.getFrameHeight() - eD.imgHeight);
            motionFlgY = false;
        }
    }
}

